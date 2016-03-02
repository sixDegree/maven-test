Ext.define('MyApp.store.UserStore',{
	extend:'Ext.data.Store',
	model:'MyApp.model.UserModel',
	proxy:{
		type:'ajax',
		//url:'resources/data/userData.json',
		url:'user/list',
		reader:{
			type:'json'
		}
	},
	autoLoad:true,
	pageSize:3
	
});