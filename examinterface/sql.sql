drop TABLE WLCB_ExamResult;
CREATE TABLE WLCB_ExamResult(
    Id uniqueidentifier NOT NULL    ,
    Sequ int     ,
    UpdHumId uniqueidentifier     ,
    UpdHuman varchar(64)     ,
    UpdDate datetime     ,
    RegDate datetime     ,
    RegHumName varchar(64)     ,
    RegHumId uniqueidentifier     ,
    OwnProjName varchar(256)     ,
    OwnProjId uniqueidentifier     ,
    EpsProjId uniqueidentifier     ,
    ApprHumId uniqueidentifier     ,
    ApprHumName varchar(64)     ,
    ApprDate datetime     ,
    Status varchar(16)     ,
    Memo varchar(1024)     ,
    Code varchar(64)     ,
    Title varchar(256)     ,
    exam_info_id varchar(64)     ,
    exam_style_name varchar(64)     ,
    exam_name varchar(128)     ,
    exam_start_time datetime     ,
    exam_end_time datetime     ,
    exam_time_restrict varchar(128)     ,
    exam_time int     ,
    exam_results_id varchar(64)     ,
    results int     ,
    is_pass bit     ,
    exam_link varchar(256)     ,
    inquire_link varchar(256)     ,
    practice_mode varchar(16)     ,
    status_exam varchar(16)     ,
    user_code varchar(64)     ,
    CONSTRAINT PK_WLCB_ExamResult PRIMARY KEY CLUSTERED (Id ASC ) ON [PRIMARY]
) ;/*SQL@Run*/

EXECUTE sp_addextendedproperty N'MS_Description', 'undefined', N'user', N'dbo', N'table', N'WLCB_ExamResult', NULL, NULL;/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '主键', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'Id';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '序号', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'Sequ';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '更新人Id', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'UpdHumId';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '更新人', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'UpdHuman';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '更新时间', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'UpdDate';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '录入时间', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'RegDate';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '录入人', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'RegHumName';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '录入人Id', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'RegHumId';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '项目名称', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'OwnProjName';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '项目id', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'OwnProjId';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '所属EpsId', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'EpsProjId';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '批准人Id', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'ApprHumId';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '批准人', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'ApprHumName';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '批准时间', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'ApprDate';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '流程审批状态:0:新增;20:审批中;35:生效;40:终止;50批准', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'Status';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '备注', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'Memo';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '编号', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'Code';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '名称', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'Title';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '考试结果id', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'exam_info_id';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '考试分类名', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'exam_style_name';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '考试名称', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'exam_name';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '考试开始时间', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'exam_start_time';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '考试结束时间', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'exam_end_time';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '考试时长限制（分钟）', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'exam_time';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '分数', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'results';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '是否及格', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'is_pass';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '考试链接', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'exam_link';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '考试结果查询链接', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'inquire_link';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '0考试；1作业', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'practice_mode';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '考试状态：new：新考试，考生可通过 examLink 去考试；
examing：正在考试中（未交卷），考生可通过 examLink 重新进入考试接着答题；
checking：批改中，examLink 和 inquireLink 都为null，不可查看；
checked：已批改，考生可通过 inquireLink 进入考试结果查询页；
notReleased：暂不发布，examLink 和 inquireLink 都为null，不可查看。', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'status_exam';/*SQL@Run*/
EXECUTE sp_addextendedproperty N'MS_Description', '考试人员', N'user', N'dbo', N'table', N'WLCB_ExamResult', N'column', N'user_code';/*SQL@Run*/