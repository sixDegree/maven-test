Ext.define('MyApp.model.TreeModel',{
	extend:'Ext.data.Model',
	fields : [
		{name : "id",type : "string"},
		{name : "text",type : "string"},
		{name : "leaf",type : "boolean"},
		{name:"type"},
		{name:"typeValue",type:"string"}
		]
});