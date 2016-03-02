Ext.define('MyApp.view.security.UserDetail',{
	extend:'Ext.panel.Panel',
	frame:true,
	layout:'border',
	
	//方法一：
	/*initComponent:function(){
		console.log('UserDetail initComponent');
		var userTplMarkup=[
				'Id: <a href="www.baidu.com" target="_blank">{id}</a><br/>',
		        'Account: {account}<br/>',
		        'Password: {password}<br/>',
		        'Enable: {enable}<br/>'
				];
		var userTpl=Ext.create('Ext.Template',userTplMarkup);
				
		var userGrid=Ext.create('MyApp.view.security.UserList',{
			region:'center',minHeight: 200,
			listeners:{selectionchange:function(sm, selectedRecord){
						if (selectedRecord.length) {
				            var detailPanel = Ext.getCmp('detailPanel');
				            userTpl.overwrite(detailPanel.body, selectedRecord[0].data);
				        }
					}}
			});
			
			
		Ext.apply(this,{
			items:[
				userGrid,
				{
	                id: 'detailPanel',
	                region: 'south',
	                layout: 'fit',
	             	split:true,
	             	minHeight: 150,
	                bodyPadding: 7,
	                bodyStyle: "background: #ffffff;",
	                html: 'Please select a book to see additional details.'
        		}
			]
		});
		
		this.callParent();
	},*/
	
	//方法二：
/*	initComponent:function(){
		console.log('UserDetail initComponent');
		this.userTpl=this.createUserTpl();
		Ext.apply(this,{
			items:[this.createUserGrid(),this.createUserDetailPanel()]	
		});
		this.callParent();
	
	},
	createUserGrid:function(){
		var userGrid=Ext.create('MyApp.view.security.UserList',{
				region:'center',layout:'fit',
				listeners:{scope: this,selectionchange:this.showUserDetail}
			});
		return userGrid;
	},
	
	createUserDetailPanel:function(){
		this.detailPanel= Ext.create('Ext.panel.Panel',{
	                id: 'detailPanel',
	                region: 'south',
	                layout: 'fit',
	             	split:true,
	             	height: '30%',
	             	collapsible: true,
	                bodyStyle: "background: #ffffff;",
	                html: 'Please select a book to see additional details.'
        		});
        return this.detailPanel;
	},
	
	createUserTpl:function(){
		var userTplMarkup=[
				'Id: <a href="www.baidu.com" target="_blank">{id}</a><br/>',
		        'Account: {account}<br/>',
		        'Password: {password}<br/>',
		        'Enable: {enable}<br/>'
				];
		var userTpl=Ext.create('Ext.Template',userTplMarkup);
		return userTpl;
	},
	
	showUserDetail:function(sm, selectedRecord){
		if (selectedRecord.length) {
            //var detailPanel = Ext.getCmp('detailPanel');
            //this.userTpl.overwrite(detailPanel.body, selectedRecord[0].data);
			this.userTpl.overwrite(this.detailPanel.body,selectedRecord[0].data);
        }
	}*///,
	
	//方法三：
	requires:['MyApp.view.security.UserList','MyApp.view.security.UserTpl'],
	initComponent:function(){
		//console.log('UserDetail initComponent');
		//this.userTpl=this.createUserTpl();
		Ext.apply(this,{
			items:[
				{xtype:'userlist',itemId:'gridPanel',region:'center',layout:'fit'},
				{xtype:'detailPanel',itemId:'detailPanel',region:'south',layout:'fit',split:true,height:'30%'}
			]	
		});
		this.callParent();
	},
	
	initEvents: function(){
		//console.log('User Detail initEvents');
		this.callParent();
		var userGridSm = this.getComponent('gridPanel').getSelectionModel();
        userGridSm.on('selectionchange', this.onRowSelect, this);
	},
	
	onRowSelect:function(sm, selectedRecord){
		if (selectedRecord.length) {
            var detailPanel = this.getComponent('detailPanel');
			detailPanel.updateDetail(selectedRecord[0].data);
        }
	}
	
});