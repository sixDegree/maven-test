Ext.define('MyApp.view.security.UserTpl',{
	extend:'Ext.panel.Panel',
	alias:'widget.detailPanel',
    //id: 'detailPanel',
 	collapsible: true,
    bodyStyle: "background: #ffffff;",
    
    tplMarkup:[
		'Id: <a href="www.baidu.com" target="_blank">{id}</a><br/>',
        'Account: {account}<br/>',
        'Password: {password}<br/>',
        'Enable: {enable}<br/>'
	],
	startingMarkup:'Please select a book to see additional details.',
	
	initComponent:function(){
		//console.log("UserTpl initComponent");
		this.tpl=Ext.create('Ext.Template',this.tplMarkup);
		this.html=this.startingMarkup;
		this.callParent();
	},
	
	updateDetail:function(data){
		this.tpl.overwrite(this.body,data);
	}
    
});