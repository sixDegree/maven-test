Ext.define('MyApp.store.TreeStore',{
	extend:'Ext.data.TreeStore',
	model:'MyApp.model.TreeModel',
	/*root: {
		text:'MenuRoot',expanded: true,id:0,
        children: [
            { text: "detention", leaf: true },
            { text: "homework", expanded: true, children: [
                { text: "book report", leaf: true },
                { text: "alegrbra", leaf: true}
            ] },
            { text: "buy lottery tickets", leaf: true }
        ]
    },*/
    
	root:{text:'MenuRoot',expanded: true,id:0},
	
	alias : 'widget.mytree', 
	proxy:{
		type:'ajax',
		url:'resources/data/treeData.json',
		reader:{type:'json'}
	},
	rootVisible:true,
	autoLoad:true
});