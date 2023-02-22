# PopUtils
## Android 常用的工具类库

> 生命有限，不要重复造轮子

### 引入依赖

1. `setting.gradle`下添加仓库

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        //...
        maven { url 'https://jitpack.io' }
    }
}
```

2. 应用的`build.gradle`下添加依赖，请注意`x.xx`对应的是需要工具的版本。本依赖库是增量更新的，理论上最新的版本包含所有的功能，但是为保证更小的体积，请尽量使用较早的版本。

```groovy
implementation 'com.github.popkter:PopUtils:vx.xx'
```

