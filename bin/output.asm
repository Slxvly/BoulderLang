global _start
_start:
    mov rax, 16
    push rax
    push QWORD [rsp + 0]
    mov rax, 33
    push rax
    push QWORD [rsp + 8]
    mov rax, 60
    pop rdi
    syscall
    mov rax, 60
    mov rdi, 0
    syscall
