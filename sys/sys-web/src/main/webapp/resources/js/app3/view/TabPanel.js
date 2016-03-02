Ext.define('MyApp.view.TabPanel',{
    extend: 'Ext.tab.Panel',
    alias:'widget.myTabPanel',
    initComponent : function(){
    	console.log('Initialized TabPanel');
        Ext.apply(this,{
            id: 'content-panel',
            region: 'center', 
            defaults: {
               autoScroll:true,
               bodyPadding: 10
            },
            activeTab: 0,
            border: false,
           //plain: true,
            items: [{
              id: 'HomePage',
              title: '首页',
              iconCls:'home',
              layout: 'fit'
            }]
        });
        this.callParent(arguments);
    }
});