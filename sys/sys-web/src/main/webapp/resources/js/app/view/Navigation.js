Ext.define('MyApp.view.Navigation',{
	extend:'Ext.panel.Panel',
	alias:'widget.navigation',
	region:'west',
	width:220,
	collapsible:true,
	split:true,
	title:'Navigation',
	layout:'accordion',
	/*items:[
		{title:'Help',html:'help1'},
		{title:'Security',html:'help1'}
	],*/
	
	tools:[
		{type:'refresh',toolTip:'Refresh the Data',handler:function(){alert('Refresh the Data !');}}
		
	],
	tbar:[
		{xtype:'button',text:'Button1'},
		'->',
		'text2',
		'-',
		{xtype:'textfield',name:'username',emptyText:'please...'}
	],
	
	initComponent:function(){
		//console.log('Navigation initComponent');
		this.callParent();
	}
	
});