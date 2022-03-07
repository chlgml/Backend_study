### @NotNull, @NotEmpty, @NotBlank 

*********

***@NotNull*** : null이 아닌지 확인

```json
{
    name : 공백이 아닌지 맞는지만 확인한다.
}
```

***@NotEmpty*** : null이 아니고 크기가 1이상인지 확인함

```json
{
    name : 공백과 크키가 1이상이 아니라면 허용하지 않음.
}
```

**@NotBlank **: null이 아니고 단순한 띄어쓰기가 아닌지 확인

```json
{
    name : 공백과 띄어쓰기 또한 허용하지 않는다.
}
```

