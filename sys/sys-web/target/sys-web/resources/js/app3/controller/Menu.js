Ext.define('MyApp.controller.Menu',{
	extend:'Ext.app.Controller',
	stores:['MyApp.store.Menu'],
	refs:[
		{ref:'myMenu',selector:'myMenu'},
		{ref:'myTabPanel',selector:'myTabPanel'}
	],
	init:function(){
		console.log("Controller Menu init !");
		this.control({
			'myMenu':{itemmousedown:this.loadMenu}
		})
	},
	loadMenu:function(selModel,record){
		if(record.get('leaf')){
			var panel=Ext.getCmp(record.get('id'));
			if(!panel){
				panel={
					title:'NewTab '+record.get('id'),
					iconCls:'tabs',
					html:'Tab Body '+record.get('id')+'<br/>',
					closable: true
				};
				this.openTab(panel,record.get('id')); 
			}
			else{
				var main=Ext.getCmp('content-panel');
				main.setActiveTab(panel);
			}
		}
	},
	openTab:function(panel,id){
		var o=(typeof pannel=="string"?panel:id);
		var main=Ext.getCmp("content-panel");
		var tab=main.getComponent(o);
		if(tab){
			main.setActiveTab(tab);
		}
		else if(typeof panel!="string"){ 
            panel.id = o; 
            var p = main.add(panel); 
            main.setActiveTab(p); 
        }  
	},
	onTreeItemClick : function(view, node) {
		console.log(node.data.component);
		var tab = Ext.getCmp("content-panel");
		if (node.isLeaf()) {
			var o=(typeof node=="string"?node:node.data.id);
			var p=tab.getComponent(o);
			if(p){
				tab.setActiveTab(p);
			}
			else{
				var panel = Ext.create('Ext.panel.Panel', {
					id:node.data.id,
					title : node.data.text,
					closable : true,
					iconCls : 'icon-activity',
					html : '<iframe width="100%" height="100%" frameborder="0" src="http://www.baidu.com"></iframe>'
				});
				tab.add(panel);
				tab.setActiveTab(panel);
			}
		}
	}
	
})