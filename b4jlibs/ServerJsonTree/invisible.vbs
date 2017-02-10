curpath = createobject("Scripting.FileSystemObject").GetFile(Wscript.ScriptFullName).ParentFolder.Path
curpath = curpath +"\Objects"
msgbox curpath

Set objShell = WScript.CreateObject("WScript.Shell")
objShell.CurrentDirectory=curpath
objShell.Run "java -jar ServerJsonTree.jar", 0, False
WScript.Sleep 1500
objShell.Run "http://127.0.0.1:88"