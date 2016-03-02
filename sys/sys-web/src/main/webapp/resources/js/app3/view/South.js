Ext.define('MyApp.view.South',{
	extend: 'Ext.toolbar.Toolbar',
	initComponent : function(){
		Ext.apply(this,{
			id:"bottom",
			//frame:true,
			region:"south",
			height:23,
			items:['->',"技术支持:<a href='http://www.nmsoyi.com' target='_blank' style='text-decoration:none;'><font color='#0000FF'>http://www.nmsoyi.com</font></a>&nbsp;&nbsp;"]
		});
		this.callParent(arguments);
	}
});