Ext.define('MyApp.view.Viewport',{
	extend:'Ext.container.Viewport',
	layout:'border',
	
	requires:['MyApp.view.Header','MyApp.view.Navigation','MyApp.view.Tree','MyApp.view.Main'],
	
/*	items:[
			Ext.create('MyApp.view.Header'),
			Ext.create('MyApp.view.Navigation'),
			//Ext.create('MyApp.view.Tree'),
			Ext.create('MyApp.view.Main'),
			{xtype:'toolbar',region:'south',
				items:[
					'->',
					"技术支持:<a href='http://www.baidu.com' target='_blank' style='text-decoration:none;'><font color='#0000FF'>http://www.baidu.com</font></a>&nbsp;&nbsp;"
				]
			}
	],*/
			
	initComponent:function(){
		//console.log('Viewport initComponent!');
		var me=this;
		Ext.apply(me,{
			items:[
				Ext.create('MyApp.view.Header'),
				Ext.create('MyApp.view.Navigation'),
				Ext.create('MyApp.view.Tree'),
				Ext.create('MyApp.view.Main'),
				{xtype:'toolbar',region:'south',
					items:[
						'->',
						"技术支持:<a href='http://www.baidu.com' target='_blank' style='text-decoration:none;'><font color='#0000FF'>http://www.baidu.com</font></a>&nbsp;&nbsp;"
					]
				}
			]
		
		});
		
		this.callParent(arguments);
	}
	
});