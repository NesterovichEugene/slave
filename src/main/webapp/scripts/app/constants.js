/**
 * Created by sergei.svirepa on 17.12.2014.
 */
var SiteMapConstants = {
    COLUMNS_COUNT: 12,
    FRAME_ORDER_COL_INDEX: 0,
    FRAME_ORDER_INFO_COL_INDEX: 11,
    ORDER_TYPE_COL_INDEX: 0,
    ORDER_DAD_COL_INDEX: 2,
    ORDER_ONLINE_COL_INDEX: 3,
    PRINT_PROFILE_COL_INDEX: 6,
    PRINTING_COL_INDEX: 7,
    AMOUNT_COL_INDEX: 8,
    PAGE_CATEGORY_COL_INDEX: 9,
    WKZ_COL_INDEX: 10,
    ORDER_PAL_COL_INDEX: 5,
    ORDER_ROWS_COUNT: 2,
    ORDER_INFO_COL_INDEX: 11,
    ORDER_PROGRESS_ROW_OFFSET: 1,
    ORDER_WORK_PACKAGES_ROW_OFFSET: 2,
    ORDER_LAST_ROW_OFFSET: 3,
    ORDER_LANGUAGE_TASKS_COL_INDEX: 6,
    ONLINE_HEADER_COL_INDEX: 2,
    ONLINE_COL_INDEX: 3,
    EUROSEITE_TASK_COL_INDEX: 2,
    CC_TASK_COL_INDEX: 3,
    GORKE_TASK_COL_INDEX: 4,
    EC_BILDER_TASK_COL_INDEX: 5,
    FRAME_ROW_INDEX: 0,
    FRAME_COL_INDEX: 0,
    ORDER_ROW_INDEX: 1,
    ORDER_COL_INDEX: 1
};


var SiteMapTable = {
    SIDES: 'Seite',
    REAL_PAGE: 'Echtseite',
    TYPE: 'Typ',
    KAT_L: 'Kat.L',
    KAT_R: 'Kat.R',
    ASSORTMENT: 'Sortiment',
    ALLOCATION: 'Zuweisung',
    AGENTS: 'Bearbeiter',
    IHU_TEMPLATE: 'IHU\nVorlage',
    TE_TEMPLATE: '2te\nVorlage',
    STATUS: 'Status',
    INFO: 'Kommentar'
};

var SiteMapTableProperties = {
    SIDES: 'page',
    REAL_PAGE: 'realPage',
    TYPE: 'type',
    KAT_L: 'katL',
    KAT_R: 'katR',
    ASSORTMENT: 'assortment',
    ALLOCATION: 'allocation',
    AGENTS: 'agents',
    IHU_TEMPLATE: 'ihuTemplate',
    TE_TEMPLATE: 'teTemplate',
    STATUS: 'status',
    INFO: 'info'
};

function CalendarConstants() {
    this.MONTH = 'month';
    this.MONTHS = 'months';
    this.WEEK = 'week';
    this.DAYS = 'days';
    this.HORIZONTAL_LINE = 'horizontal-line';
    this.PACKAGE = 'package fc-draggable';
    this.FORMAT_DATE = 'DD-MM-YYYY';
    this.TODAY = 'Heute ';
    this.MIN_DATE = '01.01.9999';
    this.MAX_DATE = '01.01.0001';
    this.INHALT = 'Inhalt';
    this.UMSCHLAG = 'Umschlag';
    this.DEFAULT_LANGUAGE = 'DE';
}

var TodoProperties = {
    FRAME_ORDER: 'frameOrder',
    WORK_PACKAGE: 'workPackage',
    PAGE: 'page',
    DISPLAY_DAD: 'displayDad',
    ALLOCATION: 'allocation',
    STATUS: 'status',
    INFO: 'info'
};

var TodoTableHeaders = {
    FRAME_ORDER: 'Werbemittel (Rahmen)vertrag',
    WORK_PACKAGE: 'Leistung',
    PAGE: 'AS/Anzahl',
    DAD: 'Fällig zum',
    ALLOCATION: 'Zugewiesen an',
    STATUS: 'Status',
    INFO: 'Info'
};

var MyTodoConstants = {
    FRAME_ORDER_COL_INDEX: 0,
    TODO_ALLOCATION_COL_INDEX: 4,
    COMPLETED_STEP_STATUS: "Farbliche Revision",
    MY_TODO_LABEL: 'mich',
    EC_BUILDER_PACKAGE_NAME: "EC-Bilder",
    CURRENT_TEST_EDITOR: "Coelho"
};

var ReportsConstants = {
    REPORT_INVOICING_INDEX: 0,
    REPORT_OPERATORS_PERFORMANCE_INDEX: 1,
    KEINE_ALLOCATION: 'keine'
};

var NewsProperties = {
    TYPE: 'type',
    DATE: 'date',
    OBJECT_TYPE: 'objectType',
    OBJECT_DESIGNATION: 'objectDesignation',
    MESSAGE: 'message'
};

var NewsConstants = {
    TYPE: 'Typ',
    DATE: 'Datum+Zeit',
    OBJECT_TYPE: 'Objekttyp',
    OBJECT_DESIGNATION: 'Objektbezeichnung',
    MESSAGE: 'Nachricht',
    EXTERNAL_TYPE: 'Extern',
    INTERNAL_TYPE: 'Intern',
    TODAY_INTERVAL: 'today',
    WEEK_INTERVAL: 'week',
    MONTH_INTERVAL: 'month',
    ALL_TIME_INTERVAL: 'allTime',
    CUSTOM_INTERVAL: 'custom'
};

