-- Create table
create table TT_ZHUBO_INFO_T
(
  user_id         VARCHAR2(32) not null,
  zhubo_name      VARCHAR2(20),
  zhubo_real_name VARCHAR2(20),
  gender          VARCHAR2(2),
  birth           DATE,
  introduce       VARCHAR2(400),
  imgdir          VARCHAR2(200),
  zhubo_group     VARCHAR2(2),
  if_vaild        VARCHAR2(2),
  url             VARCHAR2(500),
  keyword         VARCHAR2(500),
  add_date        DATE,
  modif_date      DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table TT_ZHUBO_INFO_T
  is '主播信息表';
-- Add comments to the columns 
comment on column TT_ZHUBO_INFO_T.user_id
  is '主播id';
comment on column TT_ZHUBO_INFO_T.zhubo_name
  is '主播名字';
comment on column TT_ZHUBO_INFO_T.zhubo_real_name
  is '主播真实名字';
comment on column TT_ZHUBO_INFO_T.gender
  is '性别';
comment on column TT_ZHUBO_INFO_T.birth
  is '生日';
comment on column TT_ZHUBO_INFO_T.introduce
  is '介绍';
comment on column TT_ZHUBO_INFO_T.imgdir
  is '图片介绍地址';
comment on column TT_ZHUBO_INFO_T.zhubo_group
  is '组';
comment on column TT_ZHUBO_INFO_T.if_vaild
  is '是否有效';
comment on column TT_ZHUBO_INFO_T.url
  is '主播直播地址';
comment on column TT_ZHUBO_INFO_T.keyword
  is '关键字';
comment on column TT_ZHUBO_INFO_T.add_date
  is '新增时间';
comment on column TT_ZHUBO_INFO_T.modif_date
  is '修改时间';
