Structure
========

- pskt : Contains the PureScript files and can be build using `spago`
- app/src/main/java/ps : Contains the transpiled files from `pskt`
- app/src/main/java/ps/foreigns : Contains the foreign files, that were imported 


Build
=====

```bash
# get ffi files
$ git clone https://github.com/csicar/pskt-foreigns app/src/main/java/foreigns

# build PS
cd pskt
spago build -- --codegen corefn && pskt
```

now you can build for android project in android studio

![](./screenshot.png)
