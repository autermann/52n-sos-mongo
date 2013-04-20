/**
 * Copyright (C) 2013 Christian Autermann
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
package org.n52.sos.mongo.entities;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import com.github.jmkgreen.morphia.annotations.Embedded;
import com.google.common.collect.Sets;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
public class ProcedureMetadata {
    public static final String FEATURE_OF_INTEREST_TYPES = "featureOfInterestTypes";
    public static final String OBSERVATION_TYPES = "observationTypes";
    @Embedded(FEATURE_OF_INTEREST_TYPES)
    private Set<String> featureOfInterestTypes = Sets.newHashSet();
    @Embedded(OBSERVATION_TYPES)
    private Set<String> observationTypes = Sets.newHashSet();

    public Set<String> getFeatureOfInterestTypes() {
        return Collections.unmodifiableSet(featureOfInterestTypes);
    }

    public Set<String> getObservationTypes() {
        return Collections.unmodifiableSet(observationTypes);
    }

    public ProcedureMetadata setFeatureOfInterestTypes(Set<String> featureOfInterestTypes) {
        this.featureOfInterestTypes = Sets.newHashSet(checkNotNull(featureOfInterestTypes));
        return this;
    }

    public ProcedureMetadata setObservationTypes(Set<String> observationTypes) {
        this.observationTypes = Sets.newHashSet(checkNotNull(observationTypes));
        return this;
    }

    public boolean containsFeatureOfInterestType(String o) {
        return featureOfInterestTypes.contains(checkNotNull(o));
    }

    public boolean addFeatureOfInterestType(String e) {
        return featureOfInterestTypes.add(checkNotNull(e));
    }

    public boolean removeFeatureOfInterestType(String o) {
        return featureOfInterestTypes.remove(checkNotNull(o));
    }

    public boolean containsAllFeatureOfInterestTypes(Collection<?> c) {
        return featureOfInterestTypes.containsAll(checkNotNull(c));
    }

    public boolean addAllFeatureOfInterestTypes(Collection<String> c) {
        return featureOfInterestTypes.addAll(checkNotNull(c));
    }

    public boolean removeAllFeatureOfInterestTypes(Collection<String> c) {
        return featureOfInterestTypes.removeAll(checkNotNull(c));
    }

    public boolean containsObservationType(String o) {
        return observationTypes.contains(checkNotNull(o));
    }

    public boolean addObservationType(String e) {
        return observationTypes.add(checkNotNull(e));
    }

    public boolean removeObservationType(String o) {
        return observationTypes.remove(checkNotNull(o));
    }

    public boolean containsAllObservationTypes(Collection<String> c) {
        return observationTypes.containsAll(checkNotNull(c));
    }

    public boolean addAllObservationTypes(Collection<String> c) {
        return observationTypes.addAll(checkNotNull(c));
    }

    public boolean removeAllObservationTypes(Collection<String> c) {
        return observationTypes.removeAll(checkNotNull(c));
    }
}
