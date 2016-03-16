 Select 
 acl_sid.sid,
 acl_class.class,
 cuser.username,
 acl_entry.mask,
 acl_entry.granting 
 from 
 acl_entry, acl_sid, acl_object_identity, acl_class, cuser
 where
     acl_entry.sid = acl_sid.id 
and  acl_object_identity.id = acl_entry.acl_object_identity	
and acl_object_identity.object_id_class = acl_class.id
and cuser.id = acl_object_identity.object_id_identity;