Ext.define('MyApp.view.TaskView',{
	extend:'Ext.grid.Panel',
	title:'TaskView',
	alias:'widget.taskview',
	requires:['MyApp.store.TaskStore'],
	
	viewConfig : {
		stripeRows: true
	},
	
	columnLines: false,
	
	columns: [
		{xtype:'rownumberer'},
		{text:'Task',dataIndex:'description',flex:1,tdCls: 'task',sortable: true, hideable: false,
            editor: {allowBlank: false},
            summaryType: 'count',
            summaryRenderer: function(value){ return Ext.String.format('( {0} Task{1} )',value,value!==1?'s':'');}
        }, 
        {header: 'Project',width: 200,sortable: true,dataIndex: 'project'}, 
        {header: 'Due Date',width: 130,sortable: true,dataIndex: 'due',
       		field:{xtype: 'datefield', format: 'm/d/y',//minValue: '01/01/06',
                disabledDays: [0, 6],
                disabledDaysText: 'Due date are not available on the weekends'},
        	renderer: Ext.util.Format.dateRenderer('m/d/Y'),
            summaryType: 'max',
            summaryRenderer: Ext.util.Format.dateRenderer('m/d/Y')
        }, 
        {header: 'Estimate',width: 100,sortable: true,dataIndex: 'estimate',
        	field: {xtype: 'numberfield',allowBlank: false,minValue: 0,maxValue: 24},
        	renderer: function(value){ return Ext.String.format(value + ' hours');},
            summaryType: 'sum',
            summaryRenderer:function(value){ return Ext.String.format(value + ' hours');}
        }, 
        {header: 'Rate',width: 100,sortable: true,dataIndex: 'rate',
        	field: {xtype: 'numberfield'},
            renderer: Ext.util.Format.usMoney,
            summaryType: 'average',
            summaryRenderer: Ext.util.Format.usMoney  
        }, 
        {id: 'cost', header: 'Cost',width: 100,sortable:false,dataIndex: 'cost',
            groupable: false,
            renderer: function(value, metaData, record, rowIdx, colIdx, store, view) {
                return Ext.util.Format.usMoney(record.get('estimate') * record.get('rate'));
            },
            summaryType: function(records){
                var i = 0,length = records.length,total = 0,record;
                for (; i < length; ++i) {
                    record = records[i];
                    total += record.get('estimate') * record.get('rate');
                }
                return total;
            },
            summaryRenderer: Ext.util.Format.usMoney
        },
        {
            header:'action',
            xtype: 'actioncolumn',
            width:60,
            sortable: false,
            items: [{
                icon: 'resources/images/delete.gif',
                tooltip: 'Delete Plant',
                //handler: this.removeRecord
                handler:function(gridview, rowIndex, colIndex){
                	var myStore=gridview.getStore();
                	var rec = myStore.getAt(rowIndex);
                	//confirm('Delete Confirm','Are you sure to delete this record?');
                	gridview.getStore().removeAt(rowIndex); 
                	gridview.refresh();
				}
            }]
        }
    ],
	
	features: [{
            id: 'taskGrouping',
            ftype: 'groupingsummary',
            //groupHeaderTpl: '{name}',
            groupHeaderTpl: '{columnName}: {name} ({rows.length} Item{[values.rows.length > 1 ? "s" : ""]})',
            hideGroupedHeader: true,
            enableGroupingMenu: false,
            startCollapsed: false,
            collapsible:true
        }],
        
  /* plugins: [
   		{
		ptype: 'rowexpander',
         rowBodyTpl : [
         	'<p><b>TaskId:</b> {taskId}</p>',
	        '<p><b>Task:</b> {description}</p>',
	        '<p><b>Project:</b> {project}</p>'
	      ]
   		}
   	],*/
    
    //plugins: [{ptype:'cellediting',clicksToEdit: 2}],
    plugins: [
    	{ptype:'rowediting',pluginId:'taskrowediting',clicksToEdit: 2,
    		listeners:{
    			'canceledit':function(editor,e){
    				console.log('CancelEdit!');
    			}
    		}
    	}
    	],
    
  
    selModel:Ext.create('Ext.selection.CheckboxModel'),
    
	initComponent:function(){
		console.log('TaskView InitComponent!');
		var me=this;
		me.store=Ext.create('MyApp.store.TaskStore');
		me.showSummary=true;
		me.tbar=[
			{
				tooltip:'Toggle the visibility of the summary row',
				text:'Toggle Summary',
				handler:function(){
					var gridView=me.getView();
					me.showSummary=!me.showSummary;
					gridView.getFeature('taskGrouping').toggleSummaryRow(me.showSummary);
					gridView.refresh();
				}
			},
			'-',
			{
				tooltip:'Add new record',
				text:'Add',
				handler:me.addRecord,
				scope:me
			}
		];
		
        this.callParent(arguments);
	},
	removeRecord:function(grid, rowIndex, colIndex){
		console.log("Remove Record");
		this.store.removeAt(rowIndex); 
	},
	
	addRecord:function(){
		var record=Ext.create('MyApp.model.TaskModel', {
			projectId: 100, 
			project: 'Ext Forms: Field Anchoring', 
			taskId: 112, 
			description: 'Integrate 2.0 Forms with 2.0 Layouts', 
			estimate: 6, 
			rate: 150, 
			due:Ext.Date.clearTime(new Date())
		});
		//this.getStore().insert(0,record);
		this.getStore().insert(0,new MyApp.model.TaskModel());
		this.getPlugin('taskrowediting').startEdit(0,0);
	}
	
	
});
