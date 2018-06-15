package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.Rule;

public interface RuleMapper extends Mapper<Rule> {
    Rule getRuleById(Rule rule);
}