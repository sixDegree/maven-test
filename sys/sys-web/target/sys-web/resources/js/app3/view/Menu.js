Ext.define('MyApp.view.Menu',{
    extend: 'Ext.tree.Panel',
    alias:'widget.myMenu',
    //store:Ext.create('MyApp.store.Menu'),
    store:'MyApp.store.Menu',
    initComponent : function(){
    	console.log('Initialized Menu');
        Ext.apply(this,{
            id: 'menu-panel',
            title: '系统菜单',
            iconCls:'icon-menu',
            margins : '0 0 -1 1',
            region:'west',
            border : false,
            enableDD : false,
            split: true,
            width : 212,
            minSize : 130,
            maxSize : 300,
            rootVisible: false,
            containerScroll : true,
            collapsible : true,
            autoScroll: false
        });
        this.callParent(arguments);
    }
});