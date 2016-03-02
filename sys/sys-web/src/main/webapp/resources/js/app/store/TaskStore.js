Ext.define('MyApp.store.TaskStore', {
		extend:'Ext.data.Store',
        model: 'MyApp.model.TaskModel',
        //data: data,
        proxy:{
        	type:'ajax',
        	url:'resources/data/taskData.json',
        	reader:{type:'json'}
        },
        sorters: {property: 'due', direction: 'ASC'},
        groupField: 'project',
        autoLoad:true
    });