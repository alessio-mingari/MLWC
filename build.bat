@echo off
nasm -f win64 src\alessiomingari\MLWC\resolve_operation.asm -o bin\resolve_operation.obj
gcc bin\resolve_operation.obj -o bin\resolve_operation.exe