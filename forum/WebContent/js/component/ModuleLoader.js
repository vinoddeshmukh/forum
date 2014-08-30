function loadModule(moduleKey) {
	
	console.log("User Role ---> " + localStorage.userRole);
	
	if(localStorage.userRole === "USER"){
		moduleKey= moduleKey+localStorage.userRole;
	} else if(localStorage.userRole === "ADMIN"){
		moduleKey= moduleKey+localStorage.userRole;
	}
	console.log("moduleKey : "+moduleKey);
	var json = navigationData[moduleKey];
	var moduleData = JSON.parse(json);
	
	$.ajax({dataType: "json",url:moduleData.defaultServiceUrl,
		success:function(modelData){
		console.log("moduleData.htmlPath : "+moduleData.htmlPath);
		$.ajax({url:moduleData.htmlPath,
			success:function(htmlResult){
			$("#"+moduleData.el).html(htmlResult);
			var template = $("#"+moduleData.moduleId+"-template").html();
			$("#"+moduleData.el).html(_.template(template,{modelData:modelData}));
		}});	
	}});
}

function postModule(moduleKey, form) {
	console.log("moduleKey -->"+moduleKey);
	var json = navigationData[moduleKey];
	console.log("json -->"+json);
	var moduleData = JSON.parse(json);
	console.log("moduleData --> "+moduleData);
	var frm = $("#"+form);
	console.log("form --> " + frm);
	var view = {};
	var viewArr = frm.serializeArray();
	for (var i in viewArr) {
	    view[viewArr[i].name] = viewArr[i].value;
	  }
	console.log("view --> "+view);
	var data = JSON.stringify(view);
	
	console.log("data --> "+data);
	console.log("Html path ---> " + moduleData.htmlPath);
	console.log("Module ID1 -->"+moduleData.id);
	console.log("Module EL1 -->"+moduleData.el);
	console.log("Module moduleId1 -->"+moduleData.moduleId);
	
	$.ajax({
		type: 'post',
		dataType: "json",
		url:moduleData.defaultServiceUrl,
		data: data,
		contentType: "application/json",
		accept: "application/json",
		success:function(modelData){
		$.ajax({url:moduleData.htmlPath,
			success:function(htmlResult){
			console.log("Module ID -->"+moduleData.id);
			console.log("Module EL -->"+moduleData.el);
			console.log("Module moduleId -->"+moduleData.moduleId);
			$("#"+moduleData.el).html(htmlResult);
			var template = "";
			if(moduleData.el === 'successPanel'){
				template = $("#common-template").html();
			}else{
				console.log("template name --> " + moduleData.moduleId+"-template");
				template = $("#"+moduleData.moduleId+"-template").html();
			}
			console.log("template --> " + template);
			$("#"+moduleData.el).html(_.template(template,{modelData:modelData}));
			$(".successHeader").show();
			$(".titleHeader").hide();
			$(".rowHeader").hide();
		}});	
	}});
}

function verifyLogin(moduleKey, form) {
	var json = navigationData[moduleKey];
	var moduleData = JSON.parse(json);
	var frm = $("#loginForm");
	var data = JSON.stringify(frm.serializeArray());
	$.ajax({
		type: 'post',
		dataType: "json",
		url:moduleData.defaultServiceUrl,
		data: data,
		contentType: "application/json",
		accept: "application/json",
		success:function(modelData){
		var loginData = modelData;
		userRole = loginData.userRole;
		localStorage.userRole=loginData.userRole;
		window.location = moduleData.htmlPath;
		userRole = loginData.userRole;
		
		console.log("user Role ---> login data ---> " + loginData);
		
		/*$.ajax({url:moduleData.htmlPath,
			success:function(htmlResult){
			$("#"+moduleData.el).html(htmlResult);
			var template = $("#"+moduleData.moduleId+"-template").html();
			$("#"+moduleData.el).html(_.template(template,{modelData:modelData}));
		}});	*/
	}});
}
function loadServiceDetails(component,desc){
	var id = $(component).attr("id");
	//alert(id);
	//alert("Title-->"+$("#"+id).attr("title"));
	//alert("Desc-->"+$("#"+desc).html());
	
	var context = {
			title: $("#"+id).attr("title"),
			description: $("#"+desc).html()
	}
	$.ajax({url:"pages/common/serviceDetails.html",
		success:function(htmlResult){
		$("#centerPanel").html(htmlResult);
		var template = $("#serviceDetails-template").html();
		$("#centerPanel").html(_.template(template,context));
	}});	
	
	//var id = $(component).attr("id");
	//alert(id);
	//var parentDivId = $("#"+id).parent("div").attr("id");
	//alert(parentDivId);
	//var parentDivId = $("#"+id).prev("div").attr("id");
	//var last = $("#"+id).parent().find("div:first").attr("id");
	//var last = $("#"+id).closest('.row').html();
	//alert($("#"+parentDivId).html());
	//alert("parent id="+parentDivId);
	//alert($("#"+id).parent("div").text());
	//alert(JSON.stringify(data));
	//alert("data:"+JSON.stringify(data));
	//data = JSON.parse(data);
	//var myObject = eval('(' + data + ')');
	//var jsonData = JSON.parse(data);
	//alert("data:"+jsonData);
	//alert("title:"+jsonData.title);
	//alert("description:"+jsonData.description);
}
function loadModuleDetails(component, moduleKey) {
	console.log("moduleKey:"+moduleKey);
	var rel = $(component).attr("rel");
	console.log("rel:"+rel);
	var json = navigationData[moduleKey];
	console.log("json:"+json);
	var moduleData = JSON.parse(json);
	var serviceUrl;
	if(rel.trim().length >= 8){
		serviceUrl = moduleData.defaultServiceUrl;
	}else{
		serviceUrl = moduleData.defaultServiceUrl+"/"+rel;
	}
	$.ajax({dataType: "json",url:serviceUrl,
		success:function(modelData){
		$.ajax({url:moduleData.htmlPath,
			success:function(htmlResult){
			$("#"+moduleData.el).html(htmlResult);
			var template = $("#"+moduleData.moduleId+"-template").html();
			$("#"+moduleData.el).html(_.template(template,{modelData:modelData}));
		}});	
	}});
}

function loadModuleFromBox(component, moduleKey, event) {
	var rel = $(component).attr("rel");
	var json = navigationData[moduleKey];
	var moduleData = JSON.parse(json);
	var serviceUrl;
	if(rel.trim().length >= 8){
		serviceUrl = moduleData.defaultServiceUrl;
	}else{
		serviceUrl = moduleData.defaultServiceUrl+"/"+rel;
	}
	$.ajax({dataType: "json",url:serviceUrl,
		success:function(modelData){
		$.ajax({url:moduleData.htmlPath,
			success:function(htmlResult){
			$("#cboxLoadedContent").html(htmlResult);
			var template = $(moduleData.el+"-template").html();
			$("#cboxLoadedContent").html(_.template(template,{modelData:modelData}));
		}});	
	}});
}

$.fn.serializeObject = function() {
    var o = {};
    console.log("this -->"+this.attr("rel"));
//    var a = this.serializeArray();
    $(this).find('input[type="hidden"], input[type="text"], input[type="password"], input[type="checkbox"]:checked, input[type="radio"]:checked, select').each(function() {
        if ($(this).attr('type') == 'hidden') { //if checkbox is checked do not take the hidden field
            var $parent = $(this).parent();
            var $chb = $parent.find('input[type="checkbox"][name="' + this.name.replace(/\[/g, '\[').replace(/\]/g, '\]') + '"]');
            if ($chb != null) {
                if ($chb.prop('checked')) return;
            }
        }
        if (this.name === null || this.name === undefined || this.name === '') return;
        var elemValue = null;
        if ($(this).is('select')) elemValue = $(this).find('option:selected').val();
        else elemValue = this.value;
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(elemValue || '');
        } else {
            o[this.name] = elemValue || '';
        }
    });
    return o;
    }

function formToJSON( selector )
{
     var form = {};
     $(selector).find(':input[name]:enabled').each( function() {
         var self = $(this);
         var name = self.attr('name');
         if (form[name]) {
            form[name] = form[name] + ',' + self.val();
         }
         else {
            form[name] = self.val();
         }
     });

     return form;
}
