Dim RunKcptun
Set fso = CreateObject("Scripting.FileSystemObject")
Set WshShell = WScript.CreateObject("WScript.Shell")
'��ȡ�ļ�·��
currentPath = fso.GetFile(Wscript.ScriptFullName).ParentFolder.Path & "\Objects\"
'������в���
exeConfig = currentPath&"getsscdata.jar"
cmdLine = "java -jar "&exeConfig 
'�������
WshShell.CurrentDirectory=currentPath
WshShell.Run cmdLine, 0, False
'�ȴ�1��
WScript.Sleep 1000
WshShell.Run "http://127.0.0.1:888/getsscdata?cmd=1&typ=html&num=50"
'��ӡ��������
'Wscript.echo cmdLine
Set WshShell = Nothing
Set fso = Nothing
'�˳��ű�
WScript.quit