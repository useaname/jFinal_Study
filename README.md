jFinal框架简单示例
--------------


已实现CURD

缓存,多表查询 事务 将在下一个版本中实现

##### user表API   

|字段名|信息|
| :--| :-----:|
| id | 用户id |
| name|用户姓名|
|sex|性别|


|/api/user||
| :--|---:|
|index/页码-行数|分页显示用户|
|list/页码-行数  |分页显示用户|
|add?user.name=abc | 增加一个用户|
|changeInfo?user.id=1&user.name=shabi| 更新用户信息|
|del?user.id=2|删除指定id的用户|
|getOneUser?id=2|根据传入id查询用户所有信息|
|getOneUser2?user.id=2|根据传入id查询用户所有信息|

