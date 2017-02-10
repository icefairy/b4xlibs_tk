<?php
set_time_limit(5000);
if ($_FILES["upfile"]["error"] > 0)
  {
  echo "Error: " . $_FILES["upfile"]["error"] . "<br />";
  }
else
  {
  	
	$newname=uniqid().".dat";
	move_uploaded_file($_FILES["upfile"]["tmp_name"],"up/".$newname);
	echo "file saved:up/".$newname;
  }
?>