$(document).ready(function() {
	loadModule("headerAndMenu");
	//loadModule("LP1");
	//loadModule("LP2");
	//loadModule("LP3");
	//loadModule("LP4");
	//loadModule("LP5");
	loadModule("news");
	loadModule("RecentAndLatest");
	loadModule("DocAndVedio");
	loadModule("CSAVTab");
	loadModule("centerPanel");
	loadModule("LTAF");
	loadModule("OCWOC");
	loadModule("OFW");
	localStorage.userRole='';
	
        /*$('#example').livequery(function(event) { 
        	$("#example").dataTable().fnDestroy();
            alert('clicked'); 
            setTimeout(function(){ 
                $('#example').dataTable( {
        		    "iDisplayLength": 15,
        		    "bDestroy": true
        		  } );
                },500);
        }); */
});
function loadHome(){
	loadModule("news");
	loadModule("RecentAndLatest");
	loadModule("DocAndVedio");
	loadModule("CSAVTab");
	loadModule("centerPanel");
	loadModule("LTAF");
	loadModule("OCWOC");
	loadModule("OFW");
}
/*<script>
$(document).ready(function() {
    setTimeout(function(){ 
        $('#example').dataTable( {
		    "iDisplayLength": 15
		  } );
        },500)
} );
</script>*/