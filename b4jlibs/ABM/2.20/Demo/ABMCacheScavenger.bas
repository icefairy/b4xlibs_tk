Type=Class
Version=4.7
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'CacheScavenger
Sub Class_Globals
     Private scavengeTimer As Timer
     Private ABM As ABMaterial
End Sub

Public Sub Initialize
	 scavengeTimer.Initialize("ScavengeTimer", ABMShared.CacheScavengePeriodSeconds * 1000)
	 scavengeTimer.Enabled = True
	 StartMessageLoop '<- don't forget!
End Sub

Sub ScavengeTimer_Tick
  	'do the work required		
  	ABM.ScavengeCache(ABMShared.CachedPages)
End Sub
