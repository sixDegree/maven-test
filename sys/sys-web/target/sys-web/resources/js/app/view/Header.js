Ext.define('MyApp.view.Header',{
	extend:'Ext.Component',
	xtype: 'box',
	initComponent:function(){
		//console.log('Header InitComponent');
		Ext.applyIf(this, {
            cls: 'header',
            region: 'north',
            height:50,
            html:'<h1>Back Manager</h1>'
        }); 
		this.callParent(arguments);
	}
});