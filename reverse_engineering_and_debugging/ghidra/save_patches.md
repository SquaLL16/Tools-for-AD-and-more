To save patches with ghidra with need to add a  plugin to get this functionality

1 - Download the SavePatch.py from https://github.com/schlafwandler/ghidra_SavePatch
2- Add the py scritp to the ghidra's scrip directory. You can open the scripts directory by opening the script the script manager in ghidra.
3- In the script manager create a new script and choose python. You should then see the path to the scripts directory. Add the script to that directory.
4- In the script manager click the manage script directories button and confirm that the directory is enabled.


To use the script to save your patched instructions, select the patched lines in the listing window. Since the script does not support saving multiple patches at the same time, you have to make all your modifications into one patch. So when patching multiple instructions, you need to select everything from one patched instruction to another patched instruction. Finally, go to Script Manager again to run the SavePatch.py script.

https://materials.rangeforce.com/tutorial/2020/04/12/Patching-Binaries/
