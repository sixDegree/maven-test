Ext.Loader.setConfig({enabled: true}); //开启Ext.Loader
Ext.application({
    name: 'MyApp',				//命名空间
    appFolder: 'resources/js/app3',		//应用文件夹名字
    //controllers: ['Main'],		//控制单元的名字
    controllers: ['Menu'],
	autoCreateViewport:true,
	launch:function(){
		console.log("App Launch");
		alert("App Launch");
	}
});