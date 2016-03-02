Ext.define('MyApp.controller.Frame',{
	extend:'Ext.app.Controller',
	
	views:['security.UserList','security.UserTpl'],
	//models:['MyApp.model.TreeModel','UserModel'],
	//stores:['MyApp.store.TreeStore','UserStore'],
	
	models:['MyApp.model.TreeModel'],
	stores:['MyApp.store.TreeStore'],
	
	refs:[
		{ref:'mytree',selector:'mytree'},
		{ref:'mynavigation',selector:'navigation'}
	],
	//views:['MyViewport'],
	
	init:function(){
		//console.log('Frame Init!');
		//this.getView('MyViewport').create();
	
		this.control({
			'viewport>mytree':{
				render: this.onTreeRendered
			},
			'mytree':{
				itemclick:this.onTreeItemClick
			},
			'navigation':{
				render:this.onNavigationRendered
			},
			'mytree button[action=test]':{
				click:this.onNavigationRendered
			}
			
		});
		
		//console.log('Frame InitFinish!');
	},
	
	onTreeRendered:function(){
		//console.log("Tree Render!");
	},
	onTreeItemClick:function(view,node){
		//var tab = this.getContainer();
		var tab = Ext.getCmp("content-panel");
		if (node.isLeaf()) { // 判断是否是根节点
			if (node.data.type == 'URL' || node.data.type == 'COMPONENT') { // 判断资源类型
				
				var panelType='Ext.panel.Panel';
				var content='This Tab '+node.data.id;
				
				if(node.data.type == 'COMPONENT'){
					panelType=node.data.typeValue;
					content=null;
				}
				else if(node.data.type == 'URL' && node.data.typeValue!=""){
					content='<iframe width="100%" height="100%" frameborder="0" src="'+node.data.typeValue+'"></iframe>';
				}
				
				var panel=tab.getComponent('tab'+node.data.id);
				if(!panel){
					panel = Ext.create(panelType, {
						title : node.data.text,
						id:'tab'+node.data.id,
						closable : true,
						iconCls : 'icon-activity',
						html : content
					});
					tab.add(panel);
					tab.setActiveTab(panel);
				}else{
					tab.setActiveTab(panel);
				}
			}else if (node.data.type == 'NONE') {
				alert('Information','No URL Setting!');
			}
		}
	},
	
	onNavigationRendered:function(){
		//console.log('MyNavigation Render!');
		var me=this;
		me.getMynavigation().removeAll();
		Ext.Ajax.request({
					url : 'resources/data/navigationData.json',// 获取面板的地址
					method : 'GET',
					callback : function(options, success, response) {
						//console.log('Navigation Response');
						var datas=Ext.JSON.decode(response.responseText)
						me.createTree2(datas);
						//this.createTree(response.responseText);
					}
				});
	},
	
	createTree:function(datas){	
		var me = this;
		Ext.each(datas,function(data){
			var tree=Ext.create('Ext.tree.Panel',{
				title:data.text,
				//model:me.getModel('MyApp.model.TreeModel').$className,
				//model:me.getModel('MyApp.model.TreeModel'),
				model:'MyApp.model.TreeModel',
				root:data,
				rootVisible:true
			});
			tree.on('itemclick',me.onTreeItemClick,me);
			me.getMynavigation().add(tree);
		});
	},
	
	createTree2:function(datas){	
		var me = this;
		Ext.each(datas,function(data){
			var tree=Ext.create('Ext.tree.Panel',{
				title:data.text,
				store:Ext.create('Ext.data.TreeStore',{
					model:me.getModel('MyApp.model.TreeModel'),
					root:data					
				}),
				rootVisible:true
			});
			//tree.setRootNode(me.getModel('MyApp.model.TreeModel'));
			tree.on('itemclick',me.onTreeItemClick,me);
			me.getMynavigation().add(tree);
		});
	}

});