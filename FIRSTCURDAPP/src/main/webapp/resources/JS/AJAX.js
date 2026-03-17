function SearchCourse(str){
	
	let xhttp=new XMLHttpRequest();
	
	xhttp.onreadystatechange=function()
	{
		if(this.readyState==4 && this.status==200)
			{	
				
				let TableBody=document.getElementById("tbody");
				let str=this.responseText;
				let JSONArr=JSON.parse(str);
				document.getElementById("tbody").innerHTML="";
				JSONArr.forEach(course=>{
					let tr=document.createElement("tr");
					
					let ColId=document.createElement("td");
					ColId.innerHTML=""+course.id;
					tr.appendChild(ColId);
					
					let ColName=document.createElement("td");
					ColName.innerHTML=""+course.cname;
					tr.appendChild(ColName);
					
					let updCol=document.createElement("td");
					let updlink=document.createElement("a");
					updlink.href="updt?upd="+course.id;
					updlink.innerText="Update";
					updCol.appendChild(updlink);
					tr.appendChild(updCol);
					
                    let delCol = document.createElement("td");
                    let dellink = document.createElement("a");
                    dellink.href = "delete?del=" + course.id;
                    dellink.innerText = "Delete";
                    delCol.appendChild(dellink);
                    tr.appendChild(delCol);
				
					TableBody.appendChild(tr);
					
				});
			}
	};
	
	xhttp.open("GET","search?name="+str,true);
	xhttp.send();
	
}
function Searchsub(str)
{
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		
		if(this.readyState==4 && this.status==200)
			{
				let TableBody=document.getElementById("tbdoy");
				let str=this.responseText;
				let JSONArr=JSON.parse(str);
				
				JSONArr.forEach
				
				
				
			}
		
		
		
		
		
		
	}
}





