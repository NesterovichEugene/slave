function BaseService($injector) {
    this.$injector = $injector;
}

/**
 * @param name
 * @return {*}
 */
BaseService.prototype.getDependency = function (name) {
    return this.$injector.get(name, null);
};