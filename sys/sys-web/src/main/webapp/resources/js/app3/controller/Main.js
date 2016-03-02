Ext.define('MyApp.controller.Main',{
    extend: 'Ext.app.Controller',
    stores:['MyApp.store.Menu'],
    init : function(){  
        //this.control({ });  
        console.log('Initialized Main');
  }  
    //autoCreateViewport:true
    /*
     requires:['MyApp.view.Viewport'],
     onLaunch:function(){
    	var viewport=Ext.create('MyApp.view.Viewport');
    	if(viewport)
    		viewport.show();
    },
    init : function() {
    	console.log('Initialized Main');
    	var me = this;
    	Ext.apply(me, {
    		items:[Ext.create('MyApp.view.Viewport')]
    	});
	},
	autoCreateViewport: true,*/
});