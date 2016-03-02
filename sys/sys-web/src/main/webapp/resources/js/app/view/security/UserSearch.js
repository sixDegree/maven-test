Ext.define('MyApp.view.security.UserSearch',{
	//extend:'Ext.grid.Panel',
	extend:'Ext.ux.LiveSearchGridPanel',
	title:'UserSearch',
	alias:'widget.usersearch',
	columns:[
		{xtype: 'rownumberer'},
		{text:'标识',dataIndex:'id',width:50},
		{text:'帐号',dataIndex:'account',flex:2},
		{text:'密码',dataIndex:'password',flex:1},
		//{text:'是否可用',dataIndex:'enable',width:100},
		Ext.create('Ext.ux.CheckColumn',{header:'是否可用',dataIndex:'enable',width:100})
	],
	
	selModel: {selType: 'cellmodel'},
	plugins: [{ptype:'cellediting',clicksToEdit: 1}],
	
	//forceFit: true,
	columnLines: true,
	//store:Ext.create('MyApp.store.UserStore'),
	viewConfig : {
		//loadingText : '正在加载User列表'
		stripeRows: true
	},
	
	initComponent:function(){
		//console.log('UserSearch InitComponent!');
		var me=this;
		me.store=Ext.create('MyApp.store.UserStore');
		me.fbar=Ext.create('Ext.PagingToolbar', {
            store: me.store,
            displayInfo: true,
            displayMsg: '显示 {0} - {1} 条，共计 {2} 条',
            emptyMsg: "没有数据"
        }) ;
        this.callParent(arguments);
	}
	
});
