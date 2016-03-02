Ext.define('MyApp.view.Viewport',{
    extend: 'Ext.container.Viewport',
    layout: 'fit',
    hideBorders: true,
    requires : [
        'MyApp.view.Header',
        'MyApp.view.Menu',
        'MyApp.view.TabPanel',
        'MyApp.view.South'
    ],
    
    initComponent : function(){
    	console.log('Initialized Viewport!');
        var me = this;
        Ext.apply(me, {
            items: [{
                id:'desk',
                layout: 'border',
                items: [
                    Ext.create('MyApp.view.Header'),
                    Ext.create('MyApp.view.Menu'),
                    Ext.create('MyApp.view.TabPanel'),
                    Ext.create('MyApp.view.South')
                ]
            }]
        });
        me.callParent(arguments);
    }
});