/**
 * Copyright (C) 2013
 * by 52 North Initiative for Geospatial Open Source Software GmbH
 *
 * Contact: Andreas Wytzisk
 * 52 North Initiative for Geospatial Open Source Software GmbH
 * Martin-Luther-King-Weg 24
 * 48155 Muenster, Germany
 * info@52north.org
 *
 * This program is free software; you can redistribute and/or modify it under
 * the terms of the GNU General Public License version 2 as published by the
 * Free Software Foundation.
 *
 * This program is distributed WITHOUT ANY WARRANTY; even without the implied
 * WARRANTY OF MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program (see gnu-gpl v2.txt). If not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA or
 * visit the Free Software Foundation web page, http://www.fsf.org.
 */
package org.n52.sos.mongo.transformer;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public abstract class AbstractTransformer<F, T> implements Transformer<F, T> {
    @Override
    public Collection<T> toSosObjectCollection(Collection<F> f) {
        if (f == null) {
            return Collections.emptyList();
        }
        List<T> l = Lists.newArrayListWithCapacity(f.size());
        for (F e : f) {
            l.add(toSosObject(e));
        }
        return l;
    }

    @Override
    public Collection<F> toMongoObjectCollection(Collection<T> t) {
        if (t == null) {
            return Collections.emptyList();
        }
        List<F> l = Lists.newArrayListWithCapacity(t.size());
        for (T e : t) {
            l.add(toMongoObject(e));
        }
        return l;
    }

    @Override
    public List<T> toSosObjectList(List<F> f) {
        if (f == null) {
            return Collections.emptyList();
        }
        List<T> l = Lists.newArrayListWithCapacity(f.size());
        for (F e : f) {
            l.add(toSosObject(e));
        }
        return l;
    }

    @Override
    public List<F> toMongoObjectList(List<T> t) {
        if (t == null) {
            return Collections.emptyList();
        }
        List<F> l = Lists.newArrayListWithCapacity(t.size());
        for (T e : t) {
            l.add(toMongoObject(e));
        }
        return l;
    }

    @Override
    public Set<T> toSosObjectSet(Set<F> f) {
        if (f == null) {
            return Collections.emptySet();
        }
        Set<T> s = Sets.newHashSetWithExpectedSize(f.size());
        for (F e : f) {
            s.add(toSosObject(e));
        }
        return s;
    }

    @Override
    public Set<F> toMongoObjectSet(Set<T> t) {
        if (t == null) {
            return Collections.emptySet();
        }
        Set<F> s = Sets.newHashSetWithExpectedSize(t.size());
        for (T e : t) {
            s.add(toMongoObject(e));
        }
        return s;
    }
}
