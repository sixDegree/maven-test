Ext.define('MyApp.view.MyViewport',{
	extend:'Ext.container.Viewport',
	layout:'border',
	items:[
		/*
		{xtype:'panel',region:'north',height:50,html:'<h1>Back Manager</h1>'},
		{xtype:'panel',region:'west',width:200,collapsible:true,split:true,title:'Navigation',html:'Navigation List'},
		{xtype:'tabpanel',region:'center',items:[{title:'TabPanel 1'},{title:'TabPanel 2',closable: true}]},
		{xtype:'panel',region:'south',height:30,html:'FOOTER'}*/
	
		Ext.create('Ext.Component',{region:'north',height:50,html:'<h1>Back Manager</h1>'}),
		{xtype:'panel',region:'west',width:200,collapsible:true,split:true,title:'Navigation',
			layout:'accordion',
			items:[
				{title:'Help',html:'help1'},
				{title:'Security',html:'help1'}
			]
		},
		{xtype:'panel',region:'center',title:'Main Container'},
		{xytpe:'panel',region:'east',width:300,collapsible:true,split:true,title:'East'},
		{xtype:'toolbar',region:'south',
			items:[
				{text:'Button'},
				{xtype:'splitbutton',text:'Split Button'},
				'-',
				'text1',
				{xtype:'tbspacer',width:50},
				{xtype: 'textfield',name: 'field1',emptyText: 'enter search term'},
				'->',
				"技术支持:<a href='http://www.nmsoyi.com' target='_blank' style='text-decoration:none;'><font color='#0000FF'>http://www.nmsoyi.com</font></a>&nbsp;&nbsp;"
			]
		}
	],
	initComponent:function(){
		console.log('Viewport initComponent!');
		this.callParent(arguments);
	}
	
});