/**
 * 
 */


window.addEventListener("load",bindEvents);
function makeTR(){
	
}



var printRecords=function(addEmployee)
{
    var tbody=document.getElementById("tbody");
    var tr=tbody.insertRow();
    tr.setAttribute("id",addEmployee.id);
    tr.id=addEmployee.id;
    var index=0;
    
    for(i in addEmployee)
        
        {
           
            tr.insertCell(index).innerHTML=addEmployee[i];
            index++;
        }
    var button=buttonForDelete(addEmployee);
    tr.insertCell(index).appendChild(button);
    
    index++;
    
    
           var buttonEdit=buttonForEdit(addEmployee);
           tr.insertCell(index).appendChild(buttonEdit);
    
}