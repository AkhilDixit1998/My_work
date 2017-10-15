app.factory("myFactory",function($http)
           {
    
   var object={};
    
    object.searching=function(image,scope)
    {
     
        var imageurl = "http://api.giphy.com/v1/gifs/search?q="+image+"&api_key=dc6zaTOxFJmzC";
        $http.get(imageurl).then(success,fail);
        
        function success(data)
        {
            scope.result=data.data;
            console.log("data iss "+data+" data.data is "+data.data);
        }
    
        function fail(error)
        {
           // console.log("error is er");
        }
    
    }
    
    
    return object;
    
});


/*
app.factory("serverfactory",function($http){
	var object = {
		callServer:function(searchImg,scope){
			//var tempImageUrl = "http://api.giphy.com/v1/gifs/search?q=Tom%20and%20Jerry%20&api_key=dc6zaTOxFJmzC";
			var imageurl = "http://api.giphy.com/v1/gifs/search?q="+searchImg+"&api_key=dc6zaTOxFJmzC";
			console.log("Before HTTP CALL ");
			$http.get(imageurl).then(success,fail); // this is asynch call
			console.log("After HTTP Call");
			function success(data){
				console.log("SUCCESS");
				scope.result = data.data;
			}
			function fail(er){
				console.log("FAIL");
				scope.error = er;
			}
			console.log("Exit from Call Server....");
		}
	};
	
	return object;
})*/