Ext.define('MyApp.view.Tree',{
	extend:'Ext.tree.Panel',
	alias:'widget.mytree',
	region:'east',
	width:220,
	collapsible:true,
	split:true,
	title:'Tree',
	
	/*root:{id:1,text:'Product',expanded:true,
			children:[
				{id:11,text:'PropertyType',leaf:true},
				{id:12,text:'Properties',leaf:true},
				{id:13,text:'Images',leaf:true},
				{id:14,text:'ProductList',leaf:true}
			]
	},*/
	
	//store:Ext.create('MyApp.store.TreeStore'),
	store:'MyApp.store.TreeStore',
	
	tools:[
		{type:'refresh',toolTip:'Refresh the Data',handler:function(){alert('Refresh the Data !');}},
		{id:'save',handler:function(){Ext.Msg.alert('save','Save Confirm');}},
		{id:'close'}
	],
	tbar:[
		{xtype:'button',text:'Button1',action:'test'},
		'->',
		'text2',
		'-',
		{xtype:'textfield',name:'username',emptyText:'please...'}
	],
	
	initComponent:function(){
		//console.log('Tree initComponent');
		this.callParent();
	}
});