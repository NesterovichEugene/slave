/**
 * @param $injector
 * @param $scope
 * @constructor
 */
function BaseController($injector, $scope) {
    this.$injector = $injector;
    this.unregisteredFunction = [];
    this.diffModels = [];
    this.confirmationModels = [];
    this.scope = $scope;
    this.$rootScope = $injector.get('$rootScope', null);
    this.$state = $injector.get('$state', null);
    /**
     * @type {$modal}
     */
    this.$modal = $injector.get('$modal');
    this.init();
}

/**
 * @param name
 * @return {*}
 */
BaseController.prototype.getDependency = function (name) {
    return this.$injector.get(name, null);
};


BaseController.prototype.saveAndGo = function (toState, toParams) {
    var that = this;
    that.save().then(function () {
        that.$state.go(toState, toParams);
    });
};
/**
 * @return {promise}
 */
BaseController.prototype.save = function () {
    throw  new Error("Should be override");
};

BaseController.prototype.stateChangeStart = function (event, toState, toParams) {
    var that = this;
    if (that.isConfirmed) {
        return;
    }
    if (changesNotSaved(that.confirmationModels)) {
        event.preventDefault();
        that.showConfirmDialog(
            function () {
                that.saveAndGo(toState, toParams);
            },
            function () {
                that.$state.go(toState, toParams);
            });
    }
};
BaseController.prototype.init = function () {
    var that = this;
    this.register("$destroy", function () {
        that.afterDestroy();
        that.destroy();
    });

    this.diffChanged = false;
    this.scope.safeApply = safeApplyHandler;
    this.isConfirmed = false;
    this.register('$stateChangeStart', function (event, toState, toParams) {
        that.stateChangeStart(event, toState, toParams);
    }, this.$rootScope);
};


/**
 * Register diff models
 * @param {*} model
 * @param {boolean=} confirmation if TRUE - show confirm dialog, else do nothing. default: TRUE
 */
BaseController.prototype.registerDiffModel = function (model, confirmation) {
    confirmation = (confirmation === undefined) ? true : confirmation;
    var that = this;
    if (this.diffModels.indexOf(model) > -1) {
        return;
    }
    if (!model.hasOwnProperty("_empty")) {
        throw new Error("Model should be contains 'empty' property");
    }
    this.diffModels.push(model);
    this.register(model.EMPTY_CHANGED, function () {
        that.checkDiffModels();
    });
    if (confirmation) {
        this.confirmationModels.push(model);
    }
};

/**
 *
 */
BaseController.prototype.checkDiffModels = function () {
    var that = this;
    var model = _.findWhere(that.diffModels, {empty: false});
    this.scope.safeApply(function () {
        that.diffChanged = (model !== undefined);
    });

};

/**
 * Register handler
 * @param {String} type
 * @param {Function} handler
 * @param {=} scope
 */
BaseController.prototype.register = function (type, handler, scope) {
    var processScope = scope || this.scope;
    this.unregisteredFunction.push(processScope.$on(type, handler));
};

/**
 *
 */
BaseController.prototype.destroy = function () {
    var that = this;
    _.forEach(that.unregisteredFunction, function (unregister) {
        unregister();
    });
};


/**
 *
 */
BaseController.prototype.afterDestroy = function () {
};

BaseController.prototype.showConfirmDialog = function (okHandler, noHandler, cancelHandler) {
    var that = this;
    this.$modal
        .open({
            templateUrl: 'views/common/ConfirmDialogTemplate.html',
            controller: 'ConfirmDialogController',
            resolve: {
                labels: function () {
                    return {
                        message: "Sie haben nicht gespeicherte Änderungen. Wollen Sie diese jetzt speichern?",
                        header: "Nicht gespeicherte Änderungen"
                    };
                }

            },
            backdrop: 'static'
        }
    ).
        result.then(function (value) {
            that.isConfirmed = true;
            var handler = value ? okHandler : noHandler;
            handler();
        }, cancelHandler);
}
;


/**
 * @param {Function} fn
 */
function safeApplyHandler(fn) {
    var phase = this.$root.$$phase;
    if (phase === '$apply' || phase === '$digest') {
        if (fn && typeof fn === 'function') {
            fn();
        }
    } else {
        this.$apply(fn);
    }
}

function changesNotSaved(models) {
    return _.findWhere(models, {empty: false});
}
