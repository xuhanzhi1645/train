<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Dao.*"%>
<%@ page import="java.util.*"%>
<%@ page import="entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
div{text-align:center}
</style>
<style>
body {
      background-size:cover;
      background-image:url(img/2.jpg);
      backorigin:content;
     }
</style>
<style type="text/css">

             a{

                color: white;

                /* color:#FFFFFF; */

            }

        </style>
<style type="text/css">
 .mytable{
   width:1050;
   margin:0 auto;
   margin-top:100px;
   
   opacity:1.0;
 }
 </style>
 <style>
 #a5{
		color:#3090C7;
		position:absolute;
		top:50px;/*上下*/
		left:675px;/*左右*/
		text-decoration:none;
		font-size:20px;
		}
 </style>

<title>添加员工</title>
</head>
<body>
 <a id="a5" href= "index.jsp">返回首页</a>
	
	<form action=addemployee method="post" >
		<table class="mytable" border="1" bordercolor="#0041C2">
			<tr>
				<td width="150" height= "30" style="color:#000080">ID</td>
				<td><input type="text" name="id" style="color:#000080" required="required"/></td>
			</tr>
			<tr>
				<td  width="150" height= "30"style=" color:#000080">Name</td>
				<td><input type="text" name="name" style="color:#000080" required="required"/></td>
			</tr>
			<tr>
				<td  width="150" height= "30" style="color:#000080">D_id</td>
				<td><input type="text" name="d_id" style="color:#000080" required="required"/></td>
			</tr>
			<tr>
				<td  width="150" height= "30" style="color:#000080">Tel</td>
				<td><input type="text" name="tel" style="color:#000080" required="required"/></td>
			</tr>
			<tr>
				<td  width="150" height= "30" style="color:#000080">leader_id</td>
				<td><input type="text" name="leader_id" style="color:#000080" required="required"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input  type="submit" style="color:#000080" value="添加"/></td>
			</tr>
		</table>
			<input type="hidden" name="from" value="addemployee"/>
	</form>
</body>
</html>