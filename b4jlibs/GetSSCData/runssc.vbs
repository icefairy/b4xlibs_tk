Dim RunKcptun
Set fso = CreateObject("Scripting.FileSystemObject")
Set WshShell = WScript.CreateObject("WScript.Shell")
'获取文件路径
currentPath = fso.GetFile(Wscript.ScriptFullName).ParentFolder.Path & "\Objects\"
'软件运行参数
exeConfig = currentPath&"getsscdata.jar"
cmdLine = "java -jar "&exeConfig 
'启动软件
WshShell.CurrentDirectory=currentPath
WshShell.Run cmdLine, 0, False
'等待1秒
WScript.Sleep 1000
WshShell.Run "http://127.0.0.1:888/getsscdata?cmd=1&typ=html&num=50"
'打印运行命令
'Wscript.echo cmdLine
Set WshShell = Nothing
Set fso = Nothing
'退出脚本
WScript.quit