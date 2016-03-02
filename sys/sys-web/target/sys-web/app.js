Ext.Loader.setConfig({enabled: true}); //开启Ext.Loader
/*Ext.Loader.setPath('MyApp', 'resources/js/app'); 
Ext.require(['MyApp.*']);*/

Ext.Loader.setPath('Ext.ux', 'resources/js/extjs4/examples/ux');

Ext.application({
    name: 'MyApp',				//命名空间
    appFolder: 'resources/js/app',		//应用文件夹名字
    //controllers: ['Main'],		//控制单元的名字
    controllers: ['Frame'],
	autoCreateViewport:true,
	launch:function(){
		//console.log("App Launch");
	}
});