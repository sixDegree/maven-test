Ext.define('MyApp.view.Main',{
	extend:'Ext.tab.Panel',
	region:'center',
	id:'content-panel',
	activeTab:0,
	items:[{title:'TabPanel 1',closable:true},{title:'TabPanel 2',closable:true}],
	initComponent:function(){
		//console.log('Main Container initCoomponent');
		this.callParent(arguments); 
	}
});