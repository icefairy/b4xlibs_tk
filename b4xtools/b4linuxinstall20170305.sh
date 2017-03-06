#!/bin/bash
#
# B4XLinuxInstall (version 20170305) by Sirius
# ----------------------------------------------------------------------
# A bash script for installing www.b4x.com RAD tools in Linux systems
#
#
# LINKS
# ######################################################################
# repository:   https://github.com/joseluis/B4LinuxInstall
# forum thread: http://www.b4x.com/android/forum/threads/45092/
#
#
# IMPORTANT INSTRUCTIONS
# ######################################################################
# You can download the installers for B4A and B4i and put them in the
# same directory of B4LinuxInstall. The script will find them and ask
# you if you want to install them. E.g.:
#
#	$ ls
#	  b4i-beta_18.exe b4a-trial.exe b4linuxinstall.sh
#
#	$ bash ./b4linuxinstall.sh
#	  ...
#
#
# LICENSE
# ######################################################################
# The MIT License (MIT)
#
# Copyright (c) 2015 José Luis Cruz
#
# Permission is hereby granted, free of charge, to any person obtaining
# a copy of this software and associated documentation files (the
# "Software"), to deal in the Software without restriction, including
# without limitation the rights to use, copy, modify, merge, publish,
# distribute, sublicense, and/or sell copies of the Software, and to
# permit persons to whom the Software is furnished to do so, subject to
# the following conditions:
#
# The above copyright notice and this permission notice shall be
# included in all copies or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
# EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
# MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
# IN NO EVENT SHALL# THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
# CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
# TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
# SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
# ######################################################################
# tldr; https://tldrlegal.com/license/mit-license#summary
#
#
# DISCLAIMER
# ######################################################################
# This script is not officially supported nor endorsed by Anywhere Software
# in any way, nor do I work for Anywhere Software. I am not responsible
# for any damages this script could cause to your system. I've been very
# careful to make it safe so there shouldn't be any problems, but
# ultimately you are responsible to ensure its safety before executing it.
# 
#
# THANKS TO
# ######################################################################
# - Zolive33 (Oliver MARÉ) for creating the script B4A_Installer_en,
#   from which B4LinuxInstall is built upon and tries to improve.
# - Anywhere Software (Erel Uziel) for creating the fantastic suite of
#   Rapid Application Development tools B4J, B4A and B4i.
#


# 1 GLOBAL DATA (DON'T TOUCH THIS. GO TO SECTION 2)
# ######################################################################

# Text color variables
txtred=$(tput setaf 1)     # Color Red
txtgre=$(tput setaf 2)     # Color Green
txtyel=$(tput setaf 3)     # Color Yellow
txtblu=$(tput setaf 4)     # Color Blue
txtmag=$(tput setaf 5)     # Color Magenta
txtcya=$(tput setaf 6)     # Color Cyan
txtwhi=$(tput setaf 7)     # Color White
txtbld=$(tput bold)        # Style Bold
txtund=$(tput sgr 0 1)     # Style Underline
txtRST=$(tput sgr0)        # Style Reset

txtSECT=${txtwht}${txtbld} # Section
txtINFO=${txtwhi}          # Info
txtPASS=${txtgre}          # Passed
txtWARN=${txtyel}          # Warning
txtERR=${txtred}           # Error
txtQUES=${txtmag}          # Question
txtCODE=${txtcya}          # Code

# Script permissions
chmod 770 "${0}"

# Check shell
if [ "${-}" != 'hB' ]; then
	echo "${txtERR}错误: 脚本没有正确执行！${txtRST}"
	echo "${txtINFO}请像这样运行脚本：${txtRST}"
	echo "${txtCODE}\t${0}${txtRST}"
	exit
fi

#发行版名称
DISTRO=`cat /etc/os-release | grep "PRETTY_NAME" | sed 's/PRETTY_NAME=//g' | sed 's/["]//g' | awk '{print $1}'`
if [ "${DISTRO}" != "Fedora" ] && [ "${DISTRO}" != "Ubuntu" ] && [ "${DISTRO}" != "Mint" ]; then
	read -p "此脚本未在您的系统进行测试过，可能运行不正常！你要继续吗？(y/n)" yn
	if [ "${yn}" = "n" ]; then 
		exit
	fi
fi

# 32bit or 64bit OS
[ $(uname -m) == "x86_64" ] && SObits="64" || SObits="32"


# B4J download links
b4jURL=http://www.b4x.com/b4j/files/B4J.exe
b4jFile=${b4jURL##*/}
B4JBridgeUrl=http://www.b4x.com/b4j/files/b4j-bridge.jar
B4JBridgeFile=${B4JBridgeUrl##*/}


# 2 CUSTOMIZABLE VARIABLES (ONLY TOUCH IF YOU KNOW WHAT YOU ARE DOING)
# ######################################################################

# Workspace folder
#DirWorkspace=${HOME}/AppBase/b4x
#DirAndroidSdkParentPath=${HOME}/AppBase	#DirAndroidSdkName的父目录
#DirAndroidSdkName=android-tools-linux	#以前叫android-sdk-linux

#预下载提示
echo ""
echo "    提示：开始运行脚本前，强烈建议您先下载安装过程中需要的下列文件并和脚本放在同一个目录！"
echo ""
echo "    1、jdk-7u80-windows-i586.exe (http://download.oracle.com/otn-pub/java/jdk/7u80-b15/jdk-7u80-windows-i586.exe)"
echo "    2、sdk-B4A.tar.gz (http://github.com/joseluis/B4LinuxInstall/raw/master/sdk-B4A.tar.gz)"
echo "    3、B4A_full.exe"
echo "    4、b4i.exe"
echo "    5、b4j.exe (http://www.b4x.com/b4j/files/B4J.exe)"
echo "    6、b4j-bridge.jar (http://www.b4x.com/b4j/files/b4j-bridge.jar)"
echo ""
read -p "${txtQUES}    您也可以让安装脚本自动下载这些文件，但这可能会耗费更多的时间，继续吗？(y/n)${txtRST}" yn
if [ "${yn}" = "n" ]; then
	exit
fi
#接受输入信息
echo ""
DirWorkspace=${HOME}/AppBase/b4x
read -p "${txtINFO}请输入B4X将要被安装的目录(${DirWorkspace})： ${txtRST}" uInput
if [ ! "${uInput}" = "" ]; then
	DirWorkspace=${uInput}
	uInput=""
fi
echo ""
DirAndroidSdkParentPath=${HOME}/AppBase
read -p "${txtINFO}请输入Android SDK所在的目录或将要安装的目录(${DirAndroidSdkParentPath})： ${txtRST}" uInput
if [ ! "${uInput}" = "" ]; then
	DirAndroidSdkParentPath=${uInput}
	uInput=""
fi
echo ""
DirAndroidSdkName=android-sdk-linux
read -p "${txtINFO}请输入Android SDK的目录名(${DirAndroidSdkName})： ${txtRST}" uInput
if [ ! "${uInput}" = "" ]; then
	DirAndroidSdkName=${uInput}
	uInput=""
fi


# ANDROID & WINE
# ----------------------------------------------------------------------

# Android SDK for Linux 32)

AndroidSdkUrl=http://dl.google.com/android/android-sdk_r24.0.2-linux.tgz
AndroidSdkFile=${AndroidSdkUrl##*/}

# Compatibility elements for the android SDK and Wine

AndroidSdkWineCompatUrl=http://github.com/joseluis/B4LinuxInstall/raw/master/sdk-B4A.tar.gz
AndroidSdkWineCompatFile=${AndroidSdkWineCompatUrl##*/}

# Wine version to use
case ${SObits} in
	32)
	WinePkg="wine2.2" # stable version, preferred
	;;
	64)
	WinePkg="wine2.2" # stable version, only needed in 64bit (because of dotnet)
	;;
esac

# ORACLE JAVA
# ----------------------------------------------------------------------
#
# http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
# http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

# JDK for Windows 32bit <UPDATE>
JdkWindowsUrl=http://download.oracle.com/otn-pub/java/jdk/7u80-b15/jdk-7u80-windows-i586.exe # version 1.7_80
#JdkWindowsUrl=http://download.oracle.com/otn-pub/java/jdk/8u121-b13/e9e7ea248e2c4826b92b3f075a80e441/jdk-8u121-windows-i586.exe #wine安装出错
JdkWindowsPack=${JdkWindowsUrl##*/}

# JDK for Linux <UPDATE>

case ${SObits} in
	32)
	# rpm
	JdkLinuxRpmUrl="http://download.oracle.com/otn-pub/java/jdk/8u31-b13/jdk-8u31-linux-i586.rpm"
	# tgz
	JdkLinuxTgzUrl="http://download.oracle.com/otn-pub/java/jdk/8u31-b13/jdk-8u31-linux-i586.tar.gz"
	;;
	64)
	# rpm
	JdkLinuxRpmUrl="http://download.oracle.com/otn-pub/java/jdk/8u31-b13/jdk-8u31-linux-x64.rpm"
	# tgz
	JdkLinuxTgzUrl="http://download.oracle.com/otn-pub/java/jdk/8u31-b13/jdk-8u31-linux-x64.tar.gz"
	;;
esac
JdkLinuxDebFile=${JdkLinuxDebUrl##*/}
JdkLinuxRpmFile=${JdkLinuxRpmUrl##*/}
JdkLinuxTgzFile=${JdkLinuxTgzUrl##*/}

# JavaFX Scene Builder for Linux <UPDATE>

case ${SObits} in
	32)
	JavaFxSBDebUrl=http://download.oracle.com/otn-pub/java/javafx_scenebuilder/2.0-b20/javafx_scenebuilder-2_0-linux-i586.deb
	;;
	64)
	JavaFxSBDebUrl=http://download.oracle.com/otn-pub/java/javafx_scenebuilder/2.0-b20/javafx_scenebuilder-2_0-linux-x64.deb
	;;
esac
JavaFxSBDebFile=${JavaFxSBDebUrl##*/}


# 3 UTILITY FUNCTIONS
# ######################################################################

# Checks if a command is available
# Params: $1=name
function bin_exists() {
	command -v ${1} >/dev/null 2>&1
}

# Checks if a package is installed
# Params: $1=Name
function package_exists() {

	# <DPKG>
	res=$( dpkg-query -l 2>/dev/null "${1}" | tail -1 | awk '{ print $1 }' )
	[ "${res}" == "ii" ]
}

function wgetFilter() {
# http://stackoverflow.com/a/4687912/940200
	local flag=false c count cr=$'\r' nl=$'\n'
	while IFS='' read -d '' -rn 1 c; do
		if $flag; then
			printf '%c' "$c"
		else
			if [[ $c != $cr && $c != $nl ]]; then
				count=0
			else
				((count++))
				if ((count > 1)); then
					flag=true
				fi
			fi
		fi
	done
}

# Downloads a file from oracle.com and saves it to ${DirTmp}
# Params: $1=URL
function oracle_download() {
	wget --no-cookies --no-check-certificate --header "Cookie: oraclelicense=accept-securebackup-cookie" -P ${DirTmp} ${1}
	#wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" -P ${DirTmp} ${1}
}
function oracle8_download() {
	wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" -P ${DirTmp} ${1}
}

function wget_download() {
	wget --progress=bar:force -P ${DirTmp} ${1} 2>&1 | wgetFilter
}


# 4 WINE FUNCTIONS
# ######################################################################

function init_winedir() {
	Winedir=${1}
	winTmpDirU="${Winedir}/dosdevices/c:/windows/temp"
	winTmpDirW="C:\\windows\\Temp"
}

function override_app_dlls() {
# thank's to winetricks project :-)
# example : w_override_app_dlls winword.exe riched20 native
# options native builtin default
	oad_App="${1}"
	oad_dll="${2}"
	oad_option="${3}"

	echo "REGEDIT4" > "${winTmpDirU}/override-dll.reg"
	echo "" >> "${winTmpDirU}/override-dll.reg"
	echo "[HKEY_CURRENT_USER\\Software\\Wine\\AppDefaults\\$oad_App\\DllOverrides]" >> "${winTmpDirU}/override-dll.reg"

	if [ "$oad_option" = default ]
	then
		echo "\"*$oad_dll\"=-" >> "${winTmpDirU}/override-dll.reg"
	else
		echo "\"*$oad_dll\"=\"$oad_option\"" >> "${winTmpDirU}/override-dll.reg"
	fi
	
	WINEARCH=win32 WINEPREFIX=$Winedir wine regedit "/S" "${winTmpDirW}\\override-dll.reg"

	rm ${winTmpDirU}/override-dll.reg
	unset oad_App oad_dll oad_option
}


# 5 SETUP FOLDERS
# ######################################################################
DirTmp=${DirWorkspace}/temp
DirTools=${DirWorkspace}/tools
DirWine=${DirWorkspace}/wine_b4
init_winedir ${DirWine}

# creating workspace folder
mkdir -p ${DirWorkspace}

# creating workspace folder
mkdir -p ${DirTools}

# creating temporary folder
mkdir -p ${DirTmp}


# 6 ORACLE JAVA INSTALLATION (LINUX)
# ######################################################################

echo -e "\n${txtSECT}为您的Linux系统安装java..."
echo "--------------------------------------------${txtRST}"

# <ORACLE>

# Checks java version
if bin_exists java; then
	javaFullVersion=$(java -version 2>&1 | head -1 | awk -F '"' '/version/ {print $2}' )
	javaBigVersion=$(echo ${javaFullVersion} | cut -d'.' -f1-2 )

	#echo "java -version detected: $javaFullVersion" # TEMP
fi

# Installs java
# TODO: make debian compatible
if [ "${javaBigVersion}" == "1.8" ]; then
	echo "${txtPASS}您的系统中已经安装了java ${javaBigVersion}${txtRST}"
else
	read -p "${txtQUES}JavaFX Scenebuilde和B4J需要Oracle Java 1.8，您想现在安装吗？ (y/n) ${txtRST}" yn
	if [ "${yn}" = "y" ]; then
		
		if [ "${DISTRO}" = "Ubuntu" ] || [ "${DISTRO}" = "Mint" ]; then
			# Check for the package
			if ! package_exists oracle-java8-installer; then
		
				# <UBUNTU> add the PPA
				echo "${txtINFO}将要为您的系统添加java8 ppa软件仓库:${txtRST}"
				echo "    ${txtCODE}sudo add-apt-repository ppa:webupd8team/java"
			
				read -p "${txtQUES}继续吗？ (y/n) ${txtRST}" yn
				if [ "${yn}" = "y" ]; then
					sudo add-apt-repository ppa:webupd8team/java
				fi
			fi
		
			echo "${txtINFO}接下来将要执行以下命令来安装Java 8:${txtRST}"
		
			echo "    sudo apt-get update"
			echo "    sudo apt-get install oracle-java8-installer"
			echo "    sudo update-java-alternatives -s java-8-oracle${txtRST}"
		
			read -p "${txtQUES}继续吗？(y/n) ${txtRST}" yn
			if [ "${yn}" = "y" ]; then
				sudo apt-get update
				sudo apt-get install oracle-java8-installer
				sudo update-java-alternatives -s java-8-oracle
			fi
		elif [ "${DISTRO}" = "Fedora" ]; then
			echo "${txtINFO}下载Oracle JDK 1.8...${txtRST}"
			oracle_download ${JdkLinuxRpmUrl}
			echo "${txtINFO}下载完成，接下来将要执行以下命令来安装Java 8:${txtRST}"
		
			echo "    sudo rpm -ivh ${JdkLinuxRpmFile}"
			echo "    sudo alternatives --install /usr/bin/java java /usr/java/latest/jre/bin/java 200000"
			echo "    sudo alternatives --install /usr/bin/javaws javaws /usr/java/latest/jre/bin/javaws 200000"
			echo "    sudo alternatives --install /usr/bin/javac javac /usr/java/latest/bin/javac 200000"
	
			read -p "${txtQUES}继续吗？(y/n) ${txtRST}" yn
			if [ "${yn}" = "y" ]; then
				sudo rpm -ivh ${JdkLinuxRpmFile}
				echo ""
				sudo alternatives --install /usr/bin/java java /usr/java/latest/jre/bin/java 200000
				echo ""
				sudo alternatives --install /usr/bin/javaws javaws /usr/java/latest/jre/bin/javaws 200000
				echo ""
				sudo alternatives --install /usr/bin/javac javac /usr/java/latest/bin/javac 200000
				echo ""
			fi
		else
			echo "您在未经测试的系统中运行此脚本，请手工安装Oracle JDK8再继续运行本脚本！"
			exit
		fi
	fi
fi


# 7 JAVA FX SCENE BUILDER INSTALLATION (LINUX)
# ######################################################################

# JDK8中已包含JavaFX，无须单独安装！

# <ORACLE>

echo -e "\n${txtSECT}Installation of Java FX Scenebuilder for Linux..."
echo "--------------------------------------------${txtRST}"
if ! package_exists scenebuilder; then # TODO: make a deeper check

# Package to download, depending on architecture and package manager
		
	read -p "${txtQUES}You need Oracle Java FX Scenebuilder only for B4J. Do you want to install it now? (y/n) ${txtRST}" yn

	if [ "${yn}" = "y" ]; then
			
		echo "${txtINFO}We are going to execute the following commands:${txtRST}"
		
		# <DPKG>
		echo "${txtCODE}    wget ${JavaFxSBDebUrl}${txtRST} # Simplified command"
		echo "${txtCODE}    sudo dpkg -i ${JavaFxSBDebFile}${txtRST}"
		
		read -p "${txtQUES}Continue? (y/n) ${txtRST}"
		if [ "${yn}" = "y" ]; then
			oracle_download ${JavaFxSBDebUrl}
			sudo dpkg -i ${DirTmp}/${JavaFxSBDebFile} # TODO: create function package_install
		fi
	fi
	
else
	echo "${txtPASS}You seem to have Java FX SceneBuilder already installed.${txtRST}"
fi


# 8 ANDROID SDK INSTALLATION (LINUX)
# ######################################################################

# The only components that needs to be installed are:
# Inside Tools: SDK Platform-tools + Build-tools (both selected by default)
# Inside the last stable API: SDK Platform + one System Image (e.g. x86 Atom)

echo -e "\n${txtSECT}Installation of Android SDK for Linux..."
echo "--------------------------------------------${txtRST}"

# Android SDK Installation
#if ! [ -d "${DirAndroidSdkParentPath}/android-tools-linux/" ]; then
if ! [ -d "${DirAndroidSdkParentPath}/${DirAndroidSdkName}/" ]; then	#SDK目录也用变量代替
	read -p "${txtQUES}Do you want to install Android SDK? (y/n) ${txtRST}" yn
	if [ "${yn}" = "y" ]; then
		wget_download ${AndroidSdkUrl};
		tar -zxvf ${DirTmp}/${AndroidSdkFile} -C ${DirAndroidSdkParentPath}
		#${DirAndroidSdkParentPath}/android-sdk-linux/tools/android 2>/dev/null
		${DirAndroidSdkParentPath}/${DirAndroidSdkName}/tools/android 2>/dev/null
	fi

else
	echo "${txtPASS}Android SDK is already installed${txtRST}"
	yn="n"
fi

# Adaptation for Android SDK (for Wine compatibility)
#if [ -d "${DirAndroidSdkParentPath}/android-tools-linux/tools/" ] && [ ${yn} == "y" ]; then
if [ -d "${DirAndroidSdkParentPath}/${DirAndroidSdkName}/tools/" ]; then  #如果取消了上面Android-sdk-linux的安装，仍要执行此操作（因为可能已经安装了SDK，但未装兼容部件）

	if ! [ -f "${DirAndroidSdkParentPath}/${DirAndroidSdkName}/platform-tools/adb.exe" ]; then

		echo "${txtINFO}Installing compatibility elements for Android SDK with Wine...${txtRST}"

		echo "echo OFF" > ${DirAndroidSdkParentPath}/${DirAndroidSdkName}/tools/android.bat
		echo "start /unix ${DirAndroidSdkParentPath}/${DirAndroidSdkName}/tools/android avd" >> ${DirAndroidSdkParentPath}/${DirAndroidSdkName}/tools/android.bat
		wget_download ${AndroidSdkWineCompatUrl};
		tar -xzvf ${DirTmp}/${AndroidSdkWineCompatFile} -C ${DirAndroidSdkParentPath}/${DirAndroidSdkName}
	else
		echo "${txtPASS}Compatibility elements for Android SDK with Wine are already installed${txtRST}"
	fi
fi



# 9 WINE INSTALLATION (LINUX)
# ######################################################################

echo -e "\n${txtSECT}Installation of Wine for Linux..."
echo "--------------------------------------------${txtRST}"

bin_exists wine ; wineFound=$?
bin_exists winetricks ; winetricksFound=$?

if [ $wineFound -eq 0 ]; then
	wineVers=$(wine --version | cut -d'-' -f2 | cut -d'.' -f1-2)
	echo "${txtPASS}Detected wine version ${wineVers}${txtRST}"
else
	echo "${txtWARN}Wine not found${txtRST}"
fi
if [ $winetricksFound -eq 0 ]; then
	winetricksVers=$(winetricks --version)
	echo "${txtPASS}Detected winetricks version ${winetricksVers}${txtRST}"
else
	echo "${txtWARN}Winetricks not found${txtRST}"
fi

# Installing wine
if [ $wineFound -ne 0 -o $winetricksFound -ne 0 ]; then
	echo "${txtINFO}Wine and/or winetricks do not seem to be installed on your system.${txtRST}"
	read -p "${txtQUES}Do you want to install it? (y/n) ${txtRST}" yn
	if [ "${yn}" = "y" ]; then
	
	# <UBUNTU>
	
		sudo add-apt-repository ppa:ubuntu-wine/ppa
		sudo apt-get update
		sudo apt-get install ${WinePkg} winetricks
	fi
fi

# Environment preparation for Wine (32 bits)
if ! [ -d "${DirWine}" ]; then
	echo -n "${txtINFO}We are going to configure wine folder now. ${txtRST}"
	echo "${txtQUES}Press a key to continue.${txtRST}"
	read
	
	echo "${txtINFO}Initializing Wine's environment. . .${txtRST}"
	WINEARCH=win32 WINEPREFIX=${DirWine} wine do_not_exists 2>/dev/null
	WINEARCH=win32 WINEPREFIX=${DirWine} winetricks winxp 2>/dev/null
	echo "${txtINFO}Installing .NET 4.0. . .${txtRST}"
	WINEARCH=win32 WINEPREFIX=${DirWine} winetricks dotnet40 2>/dev/null
else
	echo "${txtPASS}Environment for Wine 32 bits width dotnet40 is already installed${txtRST}"
fi


# 10 ORACLE JAVA JDK INSTALLATION (WINE)
# ######################################################################

# The only component that needs to be installed is the Development Tools
# Don't install the Source Code nor the Public JRE

echo -e "\n${txtSECT}Installation of Java 1.8 for Windows 32bit. . ."
echo "--------------------------------------------${txtRST}"
# NOTE: Java 1.8 gives error in installation
#
# <ORACLE>

# 检测当前目录下是否有jdk-7u80-windows-i586.exe文件
INSTALLER=$(ls *jdk-7u80-windows-i586.exe 2>/dev/null | head -1) # It only detects the first match

if ! [ -d "${DirWine}/drive_c/Program Files/Java/" ]; then
	read -p "${txtQUES}Do you want to install JDK for windows? (y/n) ${txtRST}" yn
	if [ "${yn}" = "y" ]; then
		# oracle_download ${JdkWindowsUrl}
		#oracle8_download ${JdkWindowsUrl}
		# WINEARCH=win32 WINEPREFIX=${DirWine} wine ${DirTmp}/${JdkWindowsPack} 2>/dev/null
		
		if [ -f "${INSTALLER}" ]; then
			echo "${txtINFO}发现JDK安装文件: '${INSTALLER}'.${txtRST}"
			read -p "${txtQUES}Do you want to install JDK using this file? (y/n) ${txtRST}" yn
			if [ "${yn}" = "y" ]; then	#直接用此文件安装
				WINEARCH=win32 WINEPREFIX=${DirWine} wine ${INSTALLER} 2>/dev/null
				yn = "n"
			fi
		else
			read -p "${txtQUES}Can't find JDK installer file. Do you want to download and install it? (y/n)${txtRST}" yn
			if [ "${yn}" = "y" ]; then
				oracle_download ${JdkWindowsUrl}
				WINEARCH=win32 WINEPREFIX=${DirWine} wine ${DirTmp}/${JdkWindowsPack} 2>/dev/null
				yn="n"
			fi
		fi

	fi
else
	echo "${txtPASS}JDK for Windows is already installed${txtRST}"
fi


# 11 B4A INSTALLATION (WINE)
# ######################################################################

echo -e "\n${txtSECT}Installation of B4A for Windows 32bit..."
echo "--------------------------------------------${txtRST}"

# Detect B4A installer in current dir
INSTALLER=$(ls *[Bb]4[Aa]*.exe 2>/dev/null | head -1) # It only detects the first match

# Detect if B4A is already installed
if [ -f "${DirWine}/drive_c/Program Files/Anywhere Software/Basic4android/Basic4android.exe" ]; then
	echo "${txtPASS}B4A is already installed${txtRST}"
    TextUpdateInstall="update"
else
	TextUpdateInstall="install"
fi

# Ask to install
if [ -f "${INSTALLER}" ]; then
    echo "${txtINFO}Found B4A installer file: '${INSTALLER}'.${txtRST}"
	read -p "${txtQUES}Do you want to ${TextUpdateInstall} B4A using this file? (y/n) ${txtRST}" yn
else
	echo "${txtWARN}Can't find B4A installer file. If you want to ${TextUpdateInstall} it, download the installer in this directory.${txtRST}"
    yn="n"
fi

if [ "${yn}" == "y" ]; then 
	#wget_download ${b4aURL}	#B4A不能直接下载
	WINEARCH=win32 WINEPREFIX=${DirWine} wine ${INSTALLER} 2>/dev/null
	override_app_dlls Basic4android.exe gdiplus native

	# App Link
	B4A_desktop="B4A.desktop" # before: Basic4android.desktop	
	echo "[Desktop Entry]" >${DirWorkspace}/${B4A_desktop}
	echo "Name=B4A" >>${DirWorkspace}/${B4A_desktop}
	echo "Exec=env WINEPREFIX="\"${DirWine}\"" wine C:\\\\\\\\windows\\\\\\\\command\\\\\\\\start.exe /Unix ${DirWine}/dosdevices/c:/users/Public/Start\\\\ Menu/Programs/Basic4android/Basic4android.lnk" >>${DirWorkspace}/${B4A_desktop}
	echo "Type=Application" >>${DirWorkspace}/${B4A_desktop}
	echo "StartupNotify=true" >>${DirWorkspace}/${B4A_desktop}
	echo "Path=${DirWine}/dosdevices/c:/Program Files/Anywhere Software/Basic4android" >>${DirWorkspace}/${B4A_desktop}
	echo "Icon=B5FB_Basic4android.0" >>${DirWorkspace}/${B4A_desktop}
	chmod +x ${DirWorkspace}/${B4A_desktop}
fi


# 12 B4J INSTALLATION (WINE)
# ######################################################################

echo -e "\n${txtSECT}Installation of B4J for Windows 32bit..."
echo "--------------------------------------------${txtRST}"

if [ -f "${DirWine}/drive_c/Program Files/Anywhere Software/B4J/B4J.exe" ]; then
	echo "${txtPASS}B4J is already installed${txtRST}"
	read -p "${txtQUES}Do you want to update B4J? (y/n) ${txtRST}" yn
else
	read -p "${txtQUES}Do you want to install B4J? (y/n) ${txtRST}" yn
fi

# Detect B4J installer in current dir
INSTALLER=$(ls *[Bb]4[Jj]*.exe 2>/dev/null | head -1) # It only detects the first match

if [ "${yn}" == "y" ]; then
	#已有B4J.exe
	# Ask to install
	if [ -f "${INSTALLER}" ]; then
    		echo "${txtINFO}Found B4J installer file: '${INSTALLER}'.${txtRST}"
		read -p "${txtQUES}Do you want to ${TextUpdateInstall} B4J using this file? (y/n) ${txtRST}" yn
	else
		echo -p "${txtQUES}未发现B4J安装文件，是否现在下载B4J？(y/n)${txtRST}" yn
	fi

	if [ "${yn}" == "y" ]; then 
		if [ -f "${INSTALLER}" ]; then
			WINEARCH=win32 WINEPREFIX=${DirWine} wine ${INSTALLER} 2>/dev/null
		else
			wget_download ${b4jURL}
			WINEARCH=win32 WINEPREFIX=${DirWine} wine ${DirTmp}/${b4jFile} 2>/dev/null
		fi
		override_app_dlls B4J.exe gdiplus native

		# App Link
		B4J_desktop="B4J.desktop"
		echo "${txtINFO}Creating link for B4J...${txtRST}"
	
		echo "[Desktop Entry]" >${DirWorkspace}/${B4J_desktop}
		echo "Name=B4J" >>${DirWorkspace}/${B4J_desktop}
		echo "Exec=env WINEPREFIX="\"${DirWine}\"" wine C:\\\\\\\\windows\\\\\\\\command\\\\\\\\start.exe /Unix ${DirWine}/dosdevices/c:/users/Public/Start\\\\ Menu/Programs/B4J/B4J.lnk" >>${DirWorkspace}/${B4J_desktop}
		echo "Type=Application" >>${DirWorkspace}/${B4J_desktop}
		echo "StartupNotify=true" >>${DirWorkspace}/${B4J_desktop}
		echo "Path=${DirWine}/dosdevices/c:/Program Files/Anywhere Software/B4J" >>${DirWorkspace}/${B4J_desktop}
		echo "Icon=7BEB_B4J.0" >>${DirWorkspace}/${B4J_desktop}
		chmod +x ${DirWorkspace}/${B4J_desktop}
	fi

	# B4J Bridge
	if ! [ -f "${DirWorkspace}/tools/${B4JBridgeFile}" ]; then
		if [ -f ${B4JBridgeFile} ]; then	
			cp ${B4JBridgeFile} ${DirTools}
		else
			echo "${txtINFO}Downloading B4J Bridge...${txtRST}"
			wget_download ${B4JBridgeUrl}
			cp ${DirTmp}/${B4JBridgeFile} ${DirTools}
		fi
	else
		echo "${txtPASS}${B4JBridgeFile} 已存在于此目录下 ${DirTools}${txtRST}"
	fi

	# B4J Bridge Link
	B4JBridge_desktop="B4JBridge.desktop"
	echo "${txtINFO}Creating link for B4J Bridge...${txtRST}"
	
	echo "[Desktop Entry]" >${DirWorkspace}/${B4JBridge_desktop}
	echo "Name=B4J Bridge" >>${DirWorkspace}/${B4JBridge_desktop}
	echo "Exec=x-terminal-emulator -t B4JBridge -e java -jar ${DirTools}/b4j-bridge.jar" >>${DirWorkspace}/${B4JBridge_desktop}
	echo "Type=Application" >>${DirWorkspace}/${B4JBridge_desktop}
	echo "StartupNotify=true" >>${DirWorkspace}/${B4JBridge_desktop}
	echo "Path=${DirWine}/dosdevices/c:/Program Files/Anywhere Software/B4J" >>${DirWorkspace}/${B4JBridge_desktop}
	echo "Icon=terminal" >>${DirWorkspace}/${B4JBridge_desktop}
	chmod +x ${DirWorkspace}/${B4JBridge_desktop}
fi


# 13 B4i INSTALLATION (WINE)
# ######################################################################

echo -e "\n${txtSECT}Installation of B4i for Windows 32bit..."
echo "--------------------------------------------${txtRST}"

# Detect B4i install erin current dir
INSTALLER=$(ls *[Bb]4[Ii]*.exe 2>/dev/null | head -1) # It only detects the first match

# Detect if B4i is already installed
if [ -f "${DirWine}/drive_c/Program Files/Anywhere Software/B4i/B4i.exe" ]; then
	echo -e "${txtPASS}B4i is already installed${txtRST}"
	TextUpdateInstall="update"
else
	TextUpdateInstall="install"
fi

# Ask to install
if [ -f "${INSTALLER}" ]; then
	echo "${txtINFO}Found B4i installer file: '${INSTALLER}'.${txtRST}"
	read -p "${txtQUES}Do you want to ${TextUpdateInstall} B4i using this file? (y/n) ${txtRST}" yn
else
	echo "${txtWARN}Can't find B4i installer file. If you want to ${TextUpdateInstall} it, download the installer in this directory.${txtRST}"
	yn="n"
fi

if [ "${yn}" == "y" ]; then
	WINEARCH=win32 WINEPREFIX=${DirWine} wine ${INSTALLER} 2>/dev/null
	override_app_dlls B4i.exe gdiplus native

	# App Link
	B4i_desktop="B4i.desktop"
	echo "${txtINFO}Creating link for B4i...${txtRST}"
	
	echo "[Desktop Entry]" >${DirWorkspace}/${B4i_desktop}
	echo "Name=B4i" >>${DirWorkspace}/${B4i_desktop}
	echo "Exec=env WINEPREFIX="\"${DirWine}\"" wine C:\\\\\\\\windows\\\\\\\\command\\\\\\\\start.exe /Unix ${DirWine}/dosdevices/c:/users/Public/Start\\\\ Menu/Programs/B4i/B4i.lnk" >>${DirWorkspace}/${B4i_desktop}
	echo "Type=Application" >>${DirWorkspace}/${B4i_desktop}
	echo "StartupNotify=true" >>${DirWorkspace}/${B4i_desktop}
	echo "Path=${DirWine}/dosdevices/c:/Program Files/Anywhere Software/B4i" >>${DirWorkspace}/${B4i_desktop}
	echo "Icon=8DA3_B4i.0" >>${DirWorkspace}/${B4i_desktop}
	chmod +x ${DirWorkspace}/${B4i_desktop}
fi


# 14 CLEANUP & EXIT
# ######################################################################

# TODO: Make this an option in the menu. Show size.

echo -e "\n${txtSECT}Cleanup & exit"
echo "--------------------------------------------${txtRST}"

read -p "${txtQUES}您想删除安装过程中下载的临时文件吗？ (y/n) ${txtRST}" yn
if [ "${yn}" = "y" ]; then
	echo "${txtINFO}Deleting ${DirTmp} . . .${txtRST}"
	rm -r ${DirTmp}
fi


echo -e "\n${txtINFO}Bye!${txtRST}\n"

