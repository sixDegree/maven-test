Ext.define('MyApp.store.UserStore',{
	extend:'Ext.data.Store',
	model:'MyApp.model.UserModel',
	proxy:{
		type:'ajax',
		url:'resources/data/userData.json',
		reader:{
			type:'json'
		}
	},
	autoLoad:true,
	pageSize:3
	
});