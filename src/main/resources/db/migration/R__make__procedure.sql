create or replace procedure refresh_acc_mat_view()
language sql
AS $$
    refresh materialized view accommodation_mat_view;
$$