Ext.define('MyApp.view.Header', {
    extend: 'Ext.Component',
    initComponent: function() {
    	console.log('Initialized Header');
        Ext.applyIf(this, {
            xtype: 'box',
            cls: 'header',
            region: 'north',
            html: '<h1>员工管理系统</h1>',
            height: 30
        });
        this.callParent(arguments);
    }
});