Ext.define('MyApp.view.security.UserList',{
	extend:'Ext.grid.Panel',
	title:'UserList',
	alias:'widget.userlist',
	/*columns:[
		{text:'标识',dataIndex:'id'},
		{text:'帐号',dataIndex:'account',flex:1},
		{text:'密码',dataIndex:'password'},
		{text:'是否可用',dataIndex:'enable'}
	],*/
	
	columns:[
		{text:'标识',dataIndex:'id',width:50},
		{text:'基本信息',width:500,	
			columns:[
				{text:'帐号',dataIndex:'account',width:200},
				{text:'密码',dataIndex:'password',width:300}
			]
		},
		{text:'是否可用',dataIndex:'enable',width:100,
			renderer:function(val) {
		        if (val) {
		            return '<span style="color:green;">' + val + '</span>';
		        } else{
		            return '<span style="color:red;">' + val + '</span>';
		        }
	        }
        }
	],
	
	columnLines: true,
	
	//store:Ext.create('MyApp.store.UserStore'),
	viewConfig : {
		//loadingText : '正在加载User列表'
		stripeRows: true
	},
	/*
	 x:20,
     y:40, 
     height:400,
     width:480,*/
     
	/*bbar:{
		xtype:'pagingtoolbar',
		store:this.store,
		displayInfo: true,
		displayMsg: '显示 {0} - {1} 条，共计 {2} 条',
        emptyMsg: "没有数据"
	},*/
	
	initComponent:function(){
		//console.log('UserList InitComponent!');
		var me=this;
		me.store=Ext.create('MyApp.store.UserStore');
		me.bbar=Ext.create('Ext.PagingToolbar', {
            store: me.store,
            displayInfo: true,
            displayMsg: '显示 {0} - {1} 条，共计 {2} 条',
            emptyMsg: "没有数据"
        }) ;
        
        me.tbar=[
			Ext.create('Ext.ux.form.SearchField',{fieldLabel: '搜索',labelWidth: 50,width: 300,store: me.store})
			//{xtype:'searchfield',fieldLabel: '搜索',labelWidth: 50,width: 300,store: me.store}
		];
        
        this.callParent(arguments);
	}
	
});
